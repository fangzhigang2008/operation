package com.fan.utils.commons_io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

public class FileUtilsTest_copy {
    public static void main(String args[]){
        try {
//            test1();
//            test2();
//            test3(); 
//            test4(); 
//            test5(); 
//            test7(); 
//            test9(); 
//            test10(); 
//            test11(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午3:54:44</li>
     * <li>3、作          者：fan</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：FileUtils.copyFile演示</li>
     * <li>6、方法说明：1、srcFile和destFile必须是文件而不能是目录；
     * 2、直接将文件srcFile拷贝到E:\\srcdest\\目录下的fandest.zip文件中
     * 3、目的目录E:\\srcdest\\如果不存在就创建一个，存在就直接往里面写数据</li>
     * 4、copy后的文件的最后修改时间还是原来的修改时间
     * 5、相当于FileUtils.copyFile(srcFile, destFile,true);</ul>
     */
    public static void test1(){
        File srcFile = new File("E:\\src\\fan.zip");
        File destFile = new File("E:\\srcdest\\fandest.zip");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午3:54:44</li>
     * <li>3、作          者：fan</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：FileUtils.copyFile演示</li>
     * <li>6、方法说明：1、srcFile和destFile必须是文件而不能是目录；
     * 2、直接将文件srcFile拷贝到E:\\srcdest\\目录下的fandest.zip文件中
     * 3、目的目录E:\\srcdest\\如果不存在就创建一个，存在就直接往里面写数据</li>
     * 4、FileUtils.copyFile(srcFile, destFile,true)copy后的文件的最后修改时间还是原来的修改时间相当于FileUtils.copyFile(srcFile, destFile)
     * 5、FileUtils.copyFile(srcFile, destFile,false)拷贝后的修改时间尝试修改为当前时间，如果修改失败也无感知</ul>
     */
    public static void test2(){
        File srcFile = new File("E:\\src\\fan.zip");
        File destFile = new File("E:\\srcdest\\fandest.zip");
        try {
            FileUtils.copyFile(srcFile, destFile,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月25日</li>
     * <li>2、开发时间：上午10:17:58</li>
     * <li>3、作          者：fan</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：1、将源文件以字节流的形式copy到输出流
     * 2、输出流可以是FileOutputStream输出流</li>
     * </ul>
     * @throws FileNotFoundException
     */
    public static void test3() throws FileNotFoundException{
        File input = new File("E:\\src\\fan.zip");
        FileOutputStream output = new FileOutputStream("E:\\srcdest\\fandest.zip");
        try {
            FileUtils.copyFile(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月25日</li>
     * <li>2、开发时间：上午11:04:59</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：1、将源文件以字节流的形式copy到输出流
     * 2、输出流可以是ByteArrayOutputStream输出流
     * 3、顺便演示彺字节数据输出流ByteArrayOutputStream里多写入一个字节</li>
     * </ul>
     * @throws FileNotFoundException
     */
    public static void test4() throws FileNotFoundException{
        File input = new File("E:\\src\\fan.zip");
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024*4);
        try {
            FileUtils.copyFile(input, baos);
            byte[] byteArray1 = new byte[1];
            byteArray1[0] = 'P';
            baos.write(byteArray1);
            byte[] byteArray = baos.toByteArray();
            System.out.println(byteArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月25日</li>
     * <li>2、开发时间：上午11:29:52</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：1、将目标文件copy至目标目录
     * 2、destDir（Destination）必须是目录不能是文件
     * 3、如果目标目录不存在就自动创建一个
     * 4、srcFile必须是一个存在的文件，而不能是一个目录或者不存在的文件
     * 5、修改时间保留为文件原来的最后修改时间
     * 6、copy后的文件名还是原来的文件名
     * 7、如果目标目录中已存在文件则覆盖原来文件
     * </li>
     * </ul>
     * @throws FileNotFoundException
     */
    public static void test5() throws FileNotFoundException{
        File srcFile = new File("E:\\src\\fan.zip");
        File destDir = new File("E:\\srcdest\\fandest.zip");
        try {
            FileUtils.copyFileToDirectory(srcFile, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月25日</li>
     * <li>2、开发时间：上午11:29:52</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：
     * 1、将目标文件copy至目标目录
     * 2、destDir（Destination）必须是目录不能是文件
     * 3、如果目标目录不存在就自动创建一个
     * 4、srcFile必须是一个存在的文件，而不能是一个目录或者不存在的文件
     * 5、FileUtils.copyFileToDirectory(srcFile, destDir,true)修改时间保留为文件原来的最后修改时间相当于FileUtils.copyFileToDirectory(srcFile, destDir);
     * 6、FileUtils.copyFileToDirectory(srcFile, destDir,false)修改时间尝试修改为当前时间，如果修改不成功也无感知
     * 7、copy后的文件名还是原来的文件名
     * 8、如果目标目录中已存在文件则覆盖原来文件</li>
     * </ul>
     * @throws FileNotFoundException
     */
    public static void test6() throws FileNotFoundException{
        File srcFile = new File("E:\\src\\fan.zip");
        File destDir = new File("E:\\srcdest\\fandest.zip");
        try {
            FileUtils.copyFileToDirectory(srcFile, destDir,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午3:57:25</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：
     * 1、直接将E:\\src\\目录下的所有文件拷贝到E:\\srcdest\\fandest目录下
     * 2、E:\\src\\必须存在并且是个目录而不能是文件；
     * 3、E:\\srcdest\\fandest可以不存在，如果不存在就创建新目录；
     * 4、E:\\srcdest\\fandest不可指定某一个文件;
     * 5、如果目标目录存在并且该目录中已经有文件存在，不影响原目录中的文件
     * 6、copy后的文件的修改时间还是原来的修改时间，相当于FileUtils.copyDirectory(srcDir, destDir, true)
     * 7、会将srcDir目录下的子目录及子文件都拷贝到目标目录中
     * 8、如果目录中的文件已经存在则覆盖原目录中的文件
     * 9、如果目录已存在则合并其中的文件
     * </li>
     * </ul>
     */
    public static void test7(){
        File srcDir = new File("E:\\src\\");
        File destDir = new File("E:\\srcdest\\fandest");
        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午4:04:32</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：
     * 1、直接将E:\\src\\目录下的所有文件拷贝到E:\\srcdest\\fandest目录下
     * 2、E:\\src\\必须存在并且是个目录而不能是文件；
     * 3、E:\\srcdest\\fandest可以不存在，如果不存在就创建新目录；
     * 4、E:\\srcdest\\fandest不可指定某一个文件;
     * 5、如果目标目录存在并且该目录中已经有文件存在，不影响原目录中的文件
     * 6、FileUtils.copyDirectory(srcDir, destDir, true)相当于FileUtils.copyDirectory(srcDir, destDir)
     * 7、FileUtils.copyDirectory(srcDir, destDir, false)在拷贝后的文件的修改日期是当前日期，如果修改为当前日期失败也无感知
     * 8、会将srcDir目录下的子目录及子文件都拷贝到目标目录中
     * 9、如果目录已存在则合并其中的文件
     * </li>
     * </ul>
     */
    public static void test8(){
        File srcDir = new File("E:\\src\\");
        File destDir = new File("E:\\srcdest\\fandest");
        try {
            FileUtils.copyDirectory(srcDir, destDir, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午3:57:25</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：
     * 1、直接将src\\目录拷贝到E:\\srcdest\\fandest目录下,这是与FileUtils.copyDirectory(srcDir, destDir)不同的地方
     * 2、E:\\src\\必须存在并且是个目录而不能是文件；
     * 3、E:\\srcdest\\fandest可以不存在，如果不存在就创建新目录；
     * 4、E:\\srcdest\\fandest不可指定某一个文件;
     * 5、如果目标目录存在并且该目录中已经有文件存在，不影响原目录中的文件
     * 6、copy后的文件的修改时间还是原来的修改时间，相当于FileUtils.copyDirectory(srcDir, destDir, true)
     * 7、会将srcDir目录下的子目录及子文件都拷贝到目标目录中
     * 8、如果目录中的文件已经存在则覆盖原目录中的文件
     * 9、如果目录已存在则合并其中的文件
     * </li>
     * </ul>
     */
    public static void test9(){
        File srcDir = new File("E:\\src\\");
        File destDir = new File("E:\\srcdest\\fandest");
        try {
            FileUtils.copyDirectoryToDirectory(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午3:57:25</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：
     * 1、直接将E:\\src\\目录下的所有文件拷贝到E:\\srcdest\\fandest目录下
     * 2、E:\\src\\必须存在并且是个目录而不能是文件；
     * 3、E:\\srcdest\\fandest可以不存在，如果不存在就创建新目录；
     * 4、E:\\srcdest\\fandest不可指定某一个文件;
     * 5、如果目标目录存在并且该目录中已经有文件存在，不影响原目录中的文件
     * 6、copy后的文件的修改时间还是原来的修改时间
     * 7、如果目录中的文件已经存在则覆盖原目录中的文件
     * 8、如果目录已存在则合并其中的文件
     * 9、根据过滤器，只copy以.txt结尾的文件
     * 10、不会过滤子目录中的文件
     * </li>
     * </ul>
     */
    public static void test10(){
        File srcDir = new File("E:\\src\\");
        File destDir = new File("E:\\srcdest\\fandest");
        try {
            FileFilter filter = FileFilterUtils.suffixFileFilter(".txt");
            FileUtils.copyDirectory(srcDir, destDir, filter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午3:57:25</li>
     * <li>3、作          者：fangzhigang</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：</li>
     * <li>6、方法说明：
     * 1、直接将E:\\src\\目录下的所有文件拷贝到E:\\srcdest\\fandest目录下
     * 2、E:\\src\\必须存在并且是个目录而不能是文件；
     * 3、E:\\srcdest\\fandest可以不存在，如果不存在就创建新目录；
     * 4、E:\\srcdest\\fandest不可指定某一个文件;
     * 5、如果目标目录存在并且该目录中已经有文件存在，不影响原目录中的文件
     * 6、copy后的文件的修改时间尝试修改为当前时间，如果修改失败也无感知
     * 7、如果目录中的文件已经存在则覆盖原目录中的文件
     * 8、如果目录已存在则合并其中的文件
     * 9、根据过滤器，只copy以.txt结尾的文件
     * 10、不会过滤子目录中的文件
     * </li>
     * </ul>
     */
    public static void test11(){
        File srcDir = new File("E:\\src\\");
        File destDir = new File("E:\\srcdest\\fandest");
        try {
            FileFilter filter = FileFilterUtils.suffixFileFilter(".txt");
            FileUtils.copyDirectory(srcDir, destDir, filter,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

