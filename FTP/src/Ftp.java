
      
    import java.io.File;      

import java.io.FileInputStream;      
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
      

import java.util.HashMap;
import java.util.logging.Logger;

    import org.apache.commons.net.ftp.FTPClient;      
import org.apache.commons.net.ftp.FTPFile;  
import org.apache.commons.net.ftp.FTPReply;      
import org.apache.commons.net.nntp.NewGroupsOrNewsQuery;
          
    /**  
     * @author   
     * 
     * @title Ftp 
     * @Description :  FTP �ϴ����ع�����  
     * @time 2013-11-27   
     */  
    public class Ftp {        
             
        private  FTPClient ftp;        
        /**    
         *     
         * @param path �ϴ���ftp�������ĸ�·����       
         * @param addr ��ַ    
         * @param port �˿ں�    
         * @param username �û���    
         * @param password ����    
         * @return    
         * @throws Exception    
         */      
       public  boolean connect(String path,String addr,int port,String username,String password) throws Exception {        
            boolean result = false;        
            ftp = new FTPClient();  
            ftp.setControlEncoding("GBK");
            int reply;        
            ftp.connect(addr,port);        
            ftp.login(username,password);        
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);        
            reply = ftp.getReplyCode();        
            if (!FTPReply.isPositiveCompletion(reply)) {        
                ftp.disconnect();        
                return result;        
            }        
            ftp.changeWorkingDirectory(path);        
            result = true;        
            return result;        
        }        
          
          
          
        /**  
         * @author   
         * @class  ItemFtp  
         * @title  upload  
         * @Description :   
         * @time 2013 2013-11-27  
         * @return void  
         * @exception :(Error note)  
         * @param file �ϴ����ļ����ļ���  
         * @param path �ϴ����ļ���·��   
         * @throws Exception  
         */  
        public void upload(File file , String path) throws Exception{     
              
            System.out.println( " file.isDirectory() : " + file.isDirectory()  );  
              
            if(file.isDirectory()){             
                ftp.makeDirectory(file.getName());                  
                ftp.changeWorkingDirectory(file.getName());        
                String[] files = file.list();               
                for (int i = 0; i < files.length; i++) {        
                    File file1 = new File(file.getPath()+"\\"+files[i] );        
                    if(file1.isDirectory()){        
                        upload(file1 , path );        
                        ftp.changeToParentDirectory();        
                    }else{                      
                        File file2 = new File(file.getPath()+"\\"+files[i]);        
                        FileInputStream input = new FileInputStream(file2);        
                        ftp.storeFile(file2.getName(), input);        
                        input.close();                              
                    }                   
                }        
            }else{        
                File file2 = new File(file.getPath());      
                  
                System.out.println( " file.getPath() : " + file.getPath()  + " | file2.getName() : " + file2.getName() );  
                  
                InputStream input = new FileInputStream(file2);     
                   
                ftp.changeWorkingDirectory(path);     
                ftp.storeFile(file2.getName(), input);        
                  
                input.close();  //�ر�������  
                ftp.logout();  //�˳�����  
            }        
        }      
          
          
             
        /**  
         * @author   
         * @class  ItemFtp  
         * @title  download  
         * @Description : FPT �����ļ�����  
         * @time 2013 2013-11-27  
         * @return void  
         * @exception :(Error note)  
         * @param reomvepath ���ص��ļ���·��   
         * @param fileName  ���ص��ļ���   
         * @param localPath ���ص��ļ�����·��  
         * @throws Exception  
         */  
        @SuppressWarnings("unused")  
        public void download(String reomvepath , HashMap<String,Course> kb, String localPath  ) throws Exception{     
        	System.out.println("ִ������");
                ftp.changeWorkingDirectory(reomvepath); 
                //ftp.listFiles()��������ʱ������
                ftp.enterLocalPassiveMode();
             // �г���Ŀ¼�������ļ�  
                FTPFile[] fs = ftp.listFiles(); 
                
                // ���������ļ����ҵ�ָ�����ļ�  
                for (FTPFile ff : fs) {  
                	System.out.println(ff.getName());
                	for(Course course:kb.values()){
                		if(ff.getName().equals(course.getCourseTeacher())){
                			ftp.changeWorkingDirectory(course.getCourseTeacher());
                			FTPFile[] kbs=ftp.listFiles();
                			for (FTPFile kbf : kbs) {  
                			//	System.out.println(kbf.getName());
                				if(kbf.getName().indexOf(course.getCourseName())>1){
                					System.out.println(kbf.getName());
                					File file=new File(localPath+"\\"+kbf.getName());
                					if(kbf.isDirectory()){
                						file.mkdir();
                					}
                					downLoadFile(ftp, kbf.getName(), file.getPath(), "");
                					//���ݾ���·����ʼ���ļ�  
                                  //  File localFile = new File(localPath + "\\" + ff.getName());  
                                    // �����  
                                   // OutputStream is = new FileOutputStream(localFile);  
                                    // �����ļ�  
                                  //  ftp.retrieveFile(kbf.getName(), is);  
                                  //  System.out.println("���سɹ�!"); 
                                   // is.close(); 
                					System.out.println("---------------");
                				}
                			}
                			
                		}
                		ftp.changeWorkingDirectory(reomvepath);
                	}
                       
                    //    
                }  
                  
                ftp.logout();  //�˳�����  
                  
        }   
        
        private void downLoadFile(FTPClient ftp, String remote, String local, String validate)  
        {  
        	
        	System.out.println(remote+"    "+local);
            try  
            {  
       
                // ת��ָ������Ŀ¼  
                ftp.changeWorkingDirectory(remote);  
       
                FTPFile[] files = ftp.listFiles();  
       
                for (FTPFile file : files)  
                {  
                	System.out.println(file.getName());
                	if(file.getName().indexOf("����")==-1){
                    if (file.isDirectory()&&!file.getName().equals(".")&&!file.getName().equals("..")) 
                    {  
                        downLoadFile(ftp, file.getName() , local + "\\" + file.getName(),  
                                validate);  
                    }  
                    else  if(!file.getName().equals(".")&&!file.getName().equals(".."))
                    {   
                        File localFile = new File(local + "\\" +file.getName());  
       
                        if (!localFile.getParentFile().exists())  
                        {  
                            localFile.getParentFile().mkdirs();  
                        }  
                        
                        if(!localFile.exists()){
                        	localFile.createNewFile();
                        }
                        
                            // ��� 
                            OutputStream is = new FileOutputStream(localFile);  
                            // �����ļ�
                            ftp.retrieveFile(file.getName(), is);  
       
                            is.close();  
                          
       
                    }  
                }  
                }
                ftp.changeToParentDirectory();
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
       
        }     
          
       public static void main(String[] args) throws Exception{      
               
           Ftp t = new Ftp();      
            
           boolean lianjie = t.connect("//", "211.80.196.1", 21, "download", "download");      
          System.out.println( "���� ��" + lianjie +"dsfddf" );  
            
          //�ϴ�  
    //      File file = new File("d:\\test.txt");    
    //      t.upload(file , "E:\\ftptest\\mulu");    
            
          //����  
          //t.download1("//", "", ""); 
            
            
       }      
    }   
