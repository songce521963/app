package com.ltkj.app.unit;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author WYJ
 *
 */
public abstract class ExcelUtil {
    /**
     * 关键字：data
     */
    public final static String DATA = "data";

    /**
     * 关键字：message
     */
    public final static String MESSAGE = "message";

    /**
     * Excel 2003
     */
    private final static String XLS = "xls";
    /**
     * Excel 2007
     */
    private final static String XLSX = "xlsx";

    /**
     * 标题占行
     */
    private final static int CLOMN_ROW = 1;

    /**
     * 第一列前边的空列数
     */
    private final static int SPACE_COL_NUM = 1;

    /**
     * Excel必须入力符号
     */
    private final static String REQUIRE = "*";

    private final static String SPLIT_STR = ":";

    private final static String REQUIRE_MESSAGE = "是必须输入的项目，请调整。";

    private final static String NO_HASH_MAP_MESSAGE = "的输入格式不正确，请按照sheet2中的内容输入。";

    private final static String MAX_LENGHT_MESSAGE = "的长度不能长于{1}个文字，请调整。";

    private final static String INTEGER_FORMAT_MESSAGE = "的输入格式不正确，请输入一个整数。";

    private final static String BIGDECIMAL_FORMAT_MESSAGE = "的输入格式不正确，请输入一个整数位{1}位,小数位{2}位的小数。";

    /**
     * 通过io获取对象及错误信息
     * 
     * @param is
     * @param extensionName
     * @param sheetNum
     * @param classType
     * @param sheet3Info
     * @return
     * @throws Exception
     */
    @SuppressWarnings("all")
    private static Map<String, Object> exportListFromIO(InputStream is, String extensionName, int sheetNum,
            Class classType, Map<String, Object> sheet3Info) throws Exception {
        List<Object> retList = new ArrayList<>();
        // List<Map<String, String>> erroList = new ArrayList<>();
        List<String> erroList = new ArrayList<>();

        Workbook workbook = null;

        if (extensionName.toLowerCase().equals(XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (extensionName.toLowerCase().equals(XLSX)) {
            workbook = new XSSFWorkbook(is);
        }

        Sheet sheet = workbook.getSheetAt(sheetNum);

        List<Map<String, String>> methodList = (List<Map<String, String>>) sheet3Info.get("methodList");
        List<String> requireList = (List<String>) sheet3Info.get("requireList");
        List<String> checkList = (List<String>) sheet3Info.get("checkList");

        List<String> titleList = new ArrayList<>();

        // 解析公式结果
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        int minRowIx = sheet.getFirstRowNum();
        int maxRowIx = sheet.getLastRowNum();
        for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
            Row row = sheet.getRow(rowIx);
            short minColIx = row.getFirstCellNum();
            short maxColIx = row.getLastCellNum();

            // 获取title
            for (short colIx = minColIx; colIx <= maxColIx && rowIx == minRowIx; colIx++) {
                Cell cell = row.getCell(new Integer(colIx));
                CellValue cellValue = evaluator.evaluate(cell);

                if (cellValue == null) {
                    continue;
                }

                // 经过公式解析，最后只存在Boolean、Numeric和String三种数据类型，此外就是Error了
                // 其余数据类型，根据官方文档，完全可以忽略http://poi.apache.org/spreadsheet/eval.html
                switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    titleList.add(cellValue.getStringValue());
                    break;
                default:
                    break;
                }
            }

            // title的情况
            if (rowIx == minRowIx) {
                continue;
            }

            // 反射创建对象
            Object obj = classType.newInstance();
            boolean nullFlag = true;
            boolean erroFlag = true;

            // 获取上传数据内容
            for (short colIx = minColIx; colIx <= maxColIx; colIx++) {
                Cell cell = row.getCell(new Integer(colIx));
                CellValue cellValue = evaluator.evaluate(cell);

                // 业务check
                int num = colIx - SPACE_COL_NUM;
                String require = requireList.get(num);

                // 必须入力check
                if (cellValue == null) {
                    // 如果字段是必须入力
                    if (REQUIRE.equals(require)) {
                        addErroList(rowIx, titleList.get(num) + REQUIRE_MESSAGE, erroList);
                        erroFlag = false;
                    }

                    continue;
                }

                // 获取的cell内容
                String content = "";
                nullFlag = false;

                // 经过公式解析，最后只存在Boolean、Numeric和String三种数据类型，此外就是Error了
                // 其余数据类型，根据官方文档，完全可以忽略http://poi.apache.org/spreadsheet/eval.html
                switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    content = String.valueOf(cellValue.getBooleanValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    // 这里的日期类型会被转换为数字类型，需要判别后区分处理
                    if (DateUtil.isCellDateFormatted(cell)) {
                        content = String.valueOf(cell.getDateCellValue());
                    } else {
                        content = String.valueOf(cellValue.getNumberValue());
                    }

                    break;
                case Cell.CELL_TYPE_STRING:
                    content = String.valueOf(cellValue.getStringValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_ERROR:
                    break;
                default:
                    break;
                }

                // 方法名称
                String methodName = methodList.get(num).get("methodName");

                // 参数类型
                String paramClass = methodList.get(num).get("paramClass");

                // 参数内容
                Object param = null;

                // 长度check
                String checkStr = checkList.get(num);

                if ("java.lang.String".equals(paramClass)) {
                    // 如果是字典表类型
                    if ("key".equals(checkStr)) {
                        String[] tempStr = content.split(SPLIT_STR, -1);

                        if (tempStr.length >= 2 && tempStr[0].length() == 2) {
                            param = tempStr[0];
                        } else {
                            addErroList(rowIx, titleList.get(num) + NO_HASH_MAP_MESSAGE, erroList);
                            erroFlag = false;
                            continue;
                        }
                    } else {
                        // 字符串长度check
                        if (content.length() > Integer.parseInt(checkStr)) {
                            addErroList(rowIx, titleList.get(num) + getErroMessage(MAX_LENGHT_MESSAGE, checkStr),
                                    erroList);
                            erroFlag = false;
                            continue;
                        } else {
                            param = content;
                        }
                    }
                } else if ("java.math.BigDecimal".equals(paramClass)) {
                    // 去逗号
                    content = content.replaceAll(",", "");

                    String[] checkStrArr = checkStr.split(",", -1);

                    String[] contentArr = content.split("\\.", -1);

                    // 如果内容有两个以上的. || 整数位比参数位数-小数位数大 || 小数位比参数小数位大
                    if (contentArr.length > 2) {
                        addErroList(rowIx,
                                titleList.get(num)
                                        + getErroMessage(BIGDECIMAL_FORMAT_MESSAGE, checkStrArr[0], checkStrArr[1]),
                                erroList);
                        erroFlag = false;
                        continue;
                    } else if (contentArr.length == 2) {
                        String pattern = "[0-9]+";
                        Pattern regex = Pattern.compile(pattern);
                        Matcher matcher1 = regex.matcher(contentArr[0]);
                        Matcher matcher2 = regex.matcher(contentArr[1]);

                        if (contentArr[0].length() > Integer.parseInt(checkStrArr[0]) - Integer.parseInt(checkStrArr[1])
                                || contentArr[1].length() > Integer.parseInt(checkStrArr[1]) || !matcher1.matches()
                                || !matcher2.matches()) {

                            addErroList(rowIx,
                                    titleList.get(num)
                                            + getErroMessage(BIGDECIMAL_FORMAT_MESSAGE, checkStrArr[0], checkStrArr[1]),
                                    erroList);
                            erroFlag = false;
                            continue;
                        }
                    } else {
                        // 数字格式check
                        String pattern = "[0-9]*";
                        Pattern regex = Pattern.compile(pattern);
                        Matcher matcher = regex.matcher(content);

                        if (!matcher.matches()) {
                            addErroList(rowIx, titleList.get(num) + getErroMessage(INTEGER_FORMAT_MESSAGE), erroList);
                            erroFlag = false;
                            continue;
                        }
                    }

                    param = new BigDecimal(content);
                } else if ("java.lang.Integer".equals(paramClass)) {
                    // 字符串长度check
                    if (content.length() > Integer.parseInt(checkStr)) {
                        addErroList(rowIx, titleList.get(num) + getErroMessage(MAX_LENGHT_MESSAGE, checkStr), erroList);
                        erroFlag = false;
                        continue;
                    } else {
                        // 去逗号
                        content = content.replaceAll(",", "");

                        // 整数格式check
                        String pattern = "[0-9]*";
                        Pattern regex = Pattern.compile(pattern);
                        Matcher matcher = regex.matcher(content);

                        if (!matcher.matches()) {
                            addErroList(rowIx, titleList.get(num) + getErroMessage(INTEGER_FORMAT_MESSAGE), erroList);
                            erroFlag = false;
                            continue;
                        } else {
                            param = new Integer(content);
                        }
                    }
                } else if ("java.util.Date".equals(paramClass)) {
                    param = new Date(content);
                }

                Method method = classType.getMethod(methodName, Class.forName(paramClass));
                method.invoke(obj, param);
            }

            if (!nullFlag && erroFlag) {
                retList.add(obj);
            }
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(DATA, retList);
        retMap.put(MESSAGE, erroList);

        return retMap;
    }

    /**
     * 获取错误信息
     * 
     * @param message
     * @param param
     * @return
     */
    private static String getErroMessage(String message, String... param) {
        int i = 0;
        for (String str : param) {
            i++;
            message = message.replace("{" + i + "}", str);
        }

        return message;
    }

    /**
     * 添加错误信息
     * 
     * @param rowIx
     * @param message
     * @param erroList
     */
    private static void addErroList(int rowIx, String message, List<String> erroList) {
        // Map<String, String> erroMap = new HashMap<String, String>();
        // erroMap.put("line", String.valueOf(rowIx + SPACE_COL_NUM));
        // erroMap.put("message", message);
        // erroList.add(erroMap);
        erroList.add("上传内容页第" + (rowIx + SPACE_COL_NUM) + "行中：" + message);
    }

    /**
     * 根据excel字段名称获取set方法名
     * 
     * @param fldName
     * @return
     */
    private static String getMothedName(String fldName) {
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        sb.append(fldName.substring(0, 1).toUpperCase());
        sb.append(fldName.substring(1, fldName.length()));

        return sb.toString();
    }

    /**
     * 获取check与映射对象信息
     * 
     * @param is
     * @param extensionName
     * @param classType
     * @return
     * @throws Exception
     */
    @SuppressWarnings("all")
    private static Map<String, Object> getSheet3Info(InputStream is, String extensionName, Class classType)
            throws Exception {
        Workbook workbook = null;

        if (extensionName.toLowerCase().equals(XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (extensionName.toLowerCase().equals(XLSX)) {
            workbook = new XSSFWorkbook(is);
        }

        Sheet sheet = workbook.getSheetAt(2);

        // 解析公式结果
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        List<Map<String, String>> methodList = new ArrayList<>();
        List<String> requireList = new ArrayList<>();
        List<String> checkList = new ArrayList<>();

        // 所有方法
        Method[] methods = classType.getMethods();

        // 第二行标签
        int minRowIx = sheet.getFirstRowNum() + CLOMN_ROW;
        int maxRowIx = sheet.getLastRowNum();
        for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
            Row row = sheet.getRow(rowIx);
            // 第一列空格
            short minColIx = (short) (row.getFirstCellNum());
            short maxColIx = row.getLastCellNum();

            for (short colIx = minColIx; colIx <= maxColIx && rowIx == minRowIx; colIx++) {
                Cell cell = row.getCell(new Integer(colIx));
                CellValue cellValue = evaluator.evaluate(cell);
                if (cellValue == null) {
                    continue;
                }

                switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    String methodName = getMothedName(cellValue.getStringValue());

                    for (Method sm : methods) {
                        // 如果匹配上了方法名
                        if (sm.getName().equals(methodName)) {
                            Class[] params = sm.getParameterTypes();

                            Map<String, String> clomnMap = new HashMap<>();
                            clomnMap.put("methodName", methodName);
                            clomnMap.put("paramClass", params[0].getName());

                            methodList.add(clomnMap);

                            continue;
                        }
                    }

                    break;
                default:
                    break;
                }
            }

            for (short colIx = minColIx; colIx <= maxColIx && rowIx == maxRowIx - 1; colIx++) {
                Cell cell = row.getCell(new Integer(colIx));
                CellValue cellValue = evaluator.evaluate(cell);
                if (cellValue == null) {
                    // 空的情况下插入空值
                    requireList.add("");
                    continue;
                }

                switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_STRING:

                    requireList.add(cellValue.getStringValue());

                    break;
                default:
                    break;
                }
            }

            for (short colIx = minColIx; colIx <= maxColIx && rowIx == maxRowIx; colIx++) {
                Cell cell = row.getCell(new Integer(colIx));
                CellValue cellValue = evaluator.evaluate(cell);
                if (cellValue == null) {
                    // 空的情况下插入空值
                    checkList.add("");
                    continue;
                }

                switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_STRING:

                    checkList.add(cellValue.getStringValue());

                    break;
                default:
                    break;
                }
            }
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("methodList", methodList);
        retMap.put("requireList", requireList);
        retMap.put("checkList", checkList);

        return retMap;
    }

    /**
     * 根据上传的excel获取对象信息与错误日志 </br>
     * 返回的map中</br>
     * key=ExcelUtil.DATA，获得对象(List<'Object'>)</br>
     * key=ExcelUtil.MESSAGE，获得错误日志(List<'String'>)</br>
     * 
     * @param file
     * @param classType
     * @return
     * @throws IOException
     */
    @SuppressWarnings("all")
    public static Map<String, Object> getObjectList(MultipartFile file, Class classType) throws IOException {
        Map<String, Object> retMap = new HashMap<>();
        InputStream is1 = null;
        InputStream is2 = null;

        String extensionName = FilenameUtils.getExtension(file.getOriginalFilename());

        try {
            is1 = file.getInputStream();
            is2 = file.getInputStream();

            Map<String, Object> Sheet3Info = getSheet3Info(is1, extensionName, classType);

            retMap = exportListFromIO(is2, extensionName, 0, classType, Sheet3Info);

        } catch (Exception e) {
            e.printStackTrace();

            List<String> messageList = new ArrayList<>();
            messageList.add("上传文件时发成错误，请确认是否是最新模板并联系管理员。");

            retMap.put(DATA, new ArrayList<>());
            retMap.put(MESSAGE, messageList);
            return retMap;
        } finally {
            is1.close();
            is2.close();
        }

        return retMap;
    }
}