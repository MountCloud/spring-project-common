package org.mountcloud.springproject.common.util;


import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * GZIP工具
 * 2018/11/26.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class GZipUtils {

    public static final int BUFFER = 1024;

    /**
     * 数据压缩
     *
     * @param data 数据
     * @return 压缩后的数据
     * @throws IOException IO异常
     */
    public static byte[] compress(byte[] data) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 压缩
        compress(bais, baos);
        byte[] output = baos.toByteArray();
        baos.flush();
        baos.close();
        bais.close();
        return output;
    }


    /**
     * 数据压缩
     * @param is 需要压缩的输入流
     * @param os 压缩后的输出流
     * @throws IOException 压缩异常
     */
    public static void compress(InputStream is, OutputStream os) throws IOException
    {

        GZIPOutputStream gos = new GZIPOutputStream(os);
        int count;
        byte data[] = new byte[BUFFER];
        while ((count = is.read(data, 0, BUFFER)) != -1) {
            gos.write(data, 0, count);
        }
        gos.finish();
        gos.flush();
        gos.close();
    }

    /**
     * 数据解压缩
     * @param data 解压缩的数据
     * @return 解压缩后的数据
     * @throws IOException 数据异常
     */
    public static byte[] decompress(byte[] data) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 解压缩
        decompress(bais, baos);
        data = baos.toByteArray();
        baos.flush();
        baos.close();
        bais.close();
        return data;
    }

    /**
     * 数据解压缩
     * @param is 解压的输入流
     * @param os 解压的输出流
     * @throws IOException 数据异常
     */
    public static void decompress(InputStream is, OutputStream os) throws IOException
    {
        GZIPInputStream gis = new GZIPInputStream(is);
        int count;
        byte data[] = new byte[BUFFER];
        while ((count = gis.read(data, 0, BUFFER)) != -1) {
            os.write(data, 0, count);
        }
        gis.close();
    }


}
