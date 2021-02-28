import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;


public class Main{
    public static void main(String[] args)
    {
        String outputString = "";

        try{
            BufferedReader readFile= new BufferedReader(new FileReader("textfiles/input.txt"));
            System.out.println("Reading from input.txt");
            String line = readFile.readLine();

            while (line != null){
                if ( line.trim().length() == 0 ) {
                    line = readFile.readLine();
                }
                else{

                    ArrayList<String> tokenArrayList = new ArrayList();
                    ArrayList<String> inputArrayList = new ArrayList();
                    String tempString= "";

                    for(int i=0; i<line.length(); i++){

                        if(!(line.charAt(i) >= 48 && line.charAt(i)<=57) && !(line.charAt(i)>= 97 && line.charAt(i)<=122) ){
                            tempString= tempString + " "+  line.charAt(i)+ " ";
                        }

                        else
                            tempString = tempString + line.charAt(i);

                    }

                    String[] arrayString= tempString.split(" ");


                    for(int j=0; j<arrayString.length; j++){

                        if(arrayString[j].length()>0){
                            Token token = new Token(arrayString[j]);
                            String tempToken= "" + token.tokenType;
                            inputArrayList.add(arrayString[j]);
                            tokenArrayList.add(tempToken);
                        }


                    }

                    String added = Parser.parseInputArray(tokenArrayList);
                    outputString = outputString + line + " - "+ added + "\n";
                    line = readFile.readLine();

                }
            }

            readFile.close();
            File file = null;
            FileWriter writeFile = null;

            try{
                file = new File("textfiles/output.txt");

                writeFile = new FileWriter(file);
                writeFile.write(outputString);
                System.out.println("Output saved in output.txt");
                writeFile.close();


            }
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writeFile != null) {
                        writeFile.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e){

            e.printStackTrace();

        }
    }
}