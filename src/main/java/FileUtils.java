import java.io.File;
import java.util.Arrays;
import java.util.Stack;

/*
 * @Author lvkai
 * @Description
 * @Date 2021/4/8 22:16
 **/
public class FileUtils {
    public static void main(String[] args) {
        File des = new File("D:\\BaiduNetdiskDownload\\01.Elasticsearch顶尖高手系列课程\\02All");
        if (des.exists()){
            des.delete();
        }
        des.mkdir();
        System.out.println(des.getAbsolutePath());
        File dir = new File("D:\\BaiduNetdiskDownload\\01.Elasticsearch顶尖高手系列课程\\02_高手进阶篇");
        System.out.println();
        Stack<File> stack = new Stack<>();
        Arrays.stream(dir.listFiles()).forEach(feDir->{
            stack.add(feDir);
        });

        while (!stack.empty()){
            File file = stack.pop();
            if (file.isDirectory()) {
                stack.addAll(Arrays.asList(file.listFiles()));
            }else {
                String absolutePath = file.getAbsolutePath();
                //System.out.println(absolutePath);
                String fileName = absolutePath.split("\\\\")[4];
                String name = file.getName();
                if (name.endsWith(".txt") || name.endsWith(".avi")){
                    String renameto = des + File.separator + fileName + "." +name.split("\\.")[1];
                    boolean b = file.renameTo(new File(renameto));
                    System.out.println("---> "+renameto+" === "+b);
                }

            }
        }

    }
}
