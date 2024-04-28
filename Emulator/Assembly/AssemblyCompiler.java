package Emulator.Assembly;

import java.io.File;
import java.util.Scanner;

public class AssemblyCompiler
{
    public AssemblyCompiler()
    {
        
    }
    
    public void compile(String fileName)
    {
        System.out.println("Compiling Started");

        File assemblyCode = new File("Data/6502AssemblyPrograms/1.txt");
        Scanner codeReader;

        // Scanner will try to read code, and will throw an exception if it doesn't exist.
        try
        {
        codeReader = new Scanner(assemblyCode);
        
        System.out.println(codeReader.nextLine());
        System.out.println(codeReader.nextLine());
        System.out.println(codeReader.nextLine());

        codeReader.close();
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        
        System.out.println("Compiling Finished");
    }
}
