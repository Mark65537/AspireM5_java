/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aspirem5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mark
 */
public class AspireM5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        CheckArgs(args);
//        AddM5(new File("C:\\Users\\Mark\\Desktop\\проги\\0А мои проги\\AspireM5\\dist\\test.ngc"));
        if(args.length>0){
            //для установки в контекстное меню
            if(args[0].equals("-cm")){
                InstallInCM();
            }
            
            for(String arg : args){
                processFilesFromFolder(new File(arg));
            }            

            JOptionPane.showMessageDialog(null,"файлы отредактированны",
                    "Info",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Использование: AspireM5 [pathToDir or pathToFile]",
                    "Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
     * обход всех файлов в папке и подпапках
     * @param      file
     */
    public static void processFilesFromFolder(File file){
     if(file.isDirectory()){
        File[] folderEntries = file.listFiles();
        for (File entry : folderEntries){
            if (entry.isDirectory()){
                processFilesFromFolder(entry);                
            }if(entry.getName().endsWith(".ngc")){
                AddM5(entry);
            }            
        }
     }else if(file.isFile() && file.getName().endsWith(".ngc")){
         AddM5(file);
     }  
    }

    private static void AddM5(File file) {
        OutputStream out =null;
        InputStream in=null;
        try{
            //чтение из файла
            in = new FileInputStream(file.getPath());
            byte[] b1=new byte[in.available()+4];
            in.read(b1, 0, in.available());
            //проверка что в файле уже есть M5
            if(Arrays.equals(Arrays.copyOfRange(b1, b1.length-15, b1.length-13),
                                                                  new byte[]{0x4d,0x35})){//M5
                return;
            }
            
            
            //чтение из файла end  
            
            byte[] b2=new byte[]{0x4d, 0x35, 0x0d, 0x0a, 0x4d, 0x32, 0x0d, 0x0a, 0x25, 0x0d, 0x0a};//M5\n M2\n %
            System.arraycopy(b2, 0, b1, b1.length-11, b2.length);
            //запись в файл
            out = new FileOutputStream(file.getPath());
            out.write(b1);
            out.flush();
            //запись в файл end
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } finally {
		try {
		    if (out != null)
			out.close();
                    if(in!=null)
                        in.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
    }
    
    public static void InstallInCM(){
        
    }
    
}
