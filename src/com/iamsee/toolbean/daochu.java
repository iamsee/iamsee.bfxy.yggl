package com.iamsee.toolbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import com.iamsee.valuebean.baseinfo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class daochu {

    /**
     * 导出数据为XLS格式
     * @param fileName        文件的名称，可以设为绝对路径，也可以设为相对路径
     * @param content        数据的内容
     */
    public static void exportExcel(String fileName, Vector<baseinfo> content) {
        WritableWorkbook wwb;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
            wwb = Workbook.createWorkbook(fos);
            WritableSheet ws = wwb.createSheet("员工表", 10);        // 创建一个工作表

            //    设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false,
                    UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); 
            wcf.setAlignment(Alignment.CENTRE); 
            ws.setRowView(1, 500);

            //    填充数据的内容
            baseinfo[] bi = new baseinfo[content.size()];
            for (int i = 0; i < content.size(); i++){
                bi[i] = (baseinfo)content.get(i);
                ws.addCell(new Label(0, i , String.valueOf(bi[i].getId()), wcf));
                ws.addCell(new Label(1, i , bi[i].getName(), wcf));
                ws.addCell(new Label(2, i , bi[i].getShortname(), wcf));
                ws.addCell(new Label(3, i , bi[i].getSex(), wcf));
                ws.addCell(new Label(4, i , bi[i].getBirth(), wcf));
                ws.addCell(new Label(5, i , bi[i].getHometowndes(), wcf));
                ws.addCell(new Label(6, i , bi[i].getIdcard(), wcf));
                ws.addCell(new Label(7, i , bi[i].getWorktime(), wcf));
                ws.addCell(new Label(8, i , bi[i].getPostname(), wcf));
                if(i == 0)
                    wcf = new WritableCellFormat();
            }

            wwb.write();
            
            wwb.close();
        } catch (IOException e){
        } catch (RowsExceededException e){
        } catch (WriteException e){}
    }

    /**
     * 从Excel文件里读取数据保存到Vector里
     * @param fileName        Excel文件的名称
     * @return                Vector对象,里面包含从Excel文件里获取到的数据
     */
    public static Vector<baseinfo> importExcel(String fileName){
        Vector<baseinfo> v = new Vector<baseinfo>();
        try {
            Workbook book = Workbook.getWorkbook(new File(fileName));
            Sheet sheet = book.getSheet(0);        // 获得第一个工作表对象 
            int rows = sheet.getRows();
            
            for(int i = 0; i < rows; i++) {
                Cell [] cell = sheet.getRow(i);
                if(cell.length == 0)
                    continue;
                
                baseinfo bi = new baseinfo();
                String contents = sheet.getCell(0, i).getContents();
                
				
                bi.setId(Integer.parseInt(contents));
                bi.setName((sheet.getCell(1, i).getContents()));
                bi.setShortname((sheet.getCell(2, i).getContents()));
                bi.setSex((sheet.getCell(3, i).getContents()));
                bi.setBirth((sheet.getCell(4, i).getContents()));
                bi.setHometowndes((sheet.getCell(5, i).getContents()));
                bi.setIdcard((sheet.getCell(6, i).getContents()));
                bi.setWorktime((sheet.getCell(7, i).getContents()));
                bi.setPostname((sheet.getCell(8, i).getContents()));
                v.add(bi);
            }

            book.close();
        }catch(Exception e) {} 
        return v;
    }
    
    public static void doit(ArrayList<baseinfo> downlist,String basePath){
        String fileName = basePath+"ygjlbak.xls";
        String fileNameNew = basePath+"ygjldown.xls";
        
        baseinfo bi0 = new baseinfo(0,"姓名","简拼","性别","生日","家乡","身份证","工作时间","所在部门");
        

        Vector<baseinfo> v = new Vector<baseinfo>();
        v.add(bi0);
        for(int i=0;i<downlist.size();i++)
        {
        	baseinfo bi = downlist.get(i);
        	v.add(bi);
        }
        
        
        exportExcel(fileName, v);
        System.out.println("成功导出数据到Excel文件(" + fileName + ")了!!!");
        
        Vector<baseinfo> vector = importExcel(fileName);
        System.out.println("成功从Excel文件(" + fileName + ")导入数据!!!");
        
        exportExcel(fileNameNew, vector);
        System.out.println("成功将" + fileName + "里的数据手复制到" + fileNameNew + "中!!!");
    }
    
    public static void  main(String args[]){
        String fileName = "d:/"+"ygjlbak.xls";
        String fileNameNew = "d:/"+"ygjldown.xls";
        
        baseinfo bi0 = new baseinfo(0,"姓名","简拼","性别","生日","家乡","身份证","工作时间","所在部门");
        

        Vector<baseinfo> v = new Vector<baseinfo>();
        v.add(bi0);
//        for(int i=0;i<downlist.size();i++)
//        {
//        	baseinfo bi = downlist.get(i);
//        	v.add(bi);
//        }
        
        
        exportExcel(fileName, v);
        System.out.println("成功导出数据到Excel文件(" + fileName + ")了!!!");
        
        Vector<baseinfo> vector = importExcel(fileName);
        System.out.println("成功从Excel文件(" + fileName + ")导入数据!!!");
        
        exportExcel(fileNameNew, vector);
        System.out.println("成功将" + fileName + "里的数据手复制到" + fileNameNew + "中!!!");
    }
}
