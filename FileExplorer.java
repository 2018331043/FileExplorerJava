import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExplorer {
    public static void main(String[] args){
        FileExplorer fileExplorer=new FileExplorer();
        if(args.length==2 && args[0].equals("explore")){
            File tempFile= new File(args[1]);
            if(tempFile.isDirectory()){
                fileExplorer.exploreFile(args[1],0);
            }
            else{
                System.out.println("The Given Path Is Not A Directory");
            }
        }
    }
    private void exploreFile(String fileDirectory,Integer spaces){
        File exploreFolder = new File(fileDirectory);
        final Integer cnt=spaces;
        //System.out.println("Folder exploring");
        List<File> curDirFiles = Arrays.asList(exploreFolder.listFiles());
        curDirFiles.forEach((v)->{
            printSpaces(cnt);
            System.out.println(v.getName());
            if(v.isDirectory()){
                exploreFile(v.getPath(),cnt+1);
            }
        });
        //System.out.println(curDirFiles);
    }
    private void printSpaces(Integer spaces){
        for(int i=0;i<spaces-1;i++){
            System.out.print("   ");
        }
        System.out.print("|---");
    }
}
