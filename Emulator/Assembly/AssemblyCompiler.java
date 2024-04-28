package Emulator.Assembly;

import java.io.File;
import java.util.HexFormat;
import java.util.Scanner;
import java.nio.file.*;
import java.io.InputStream;
import java.io.FileInputStream;

public class AssemblyCompiler
{
    static HexFormat hex = HexFormat.of();

    // PROGRAM RAM
    byte[] ram = new byte[4096];

    public AssemblyCompiler()
    {
        
    }
    
    public void read(String fileName)
    {
        System.out.println("Compiling Started");

        fileName = "Roms/Adventure.a26";
        File assemblyCode = new File(fileName);

        try
        {
            InputStream byteReader = new FileInputStream(assemblyCode);
            
            int i = 0;
            int readByte = 0;
            // This readByte is in [0,255]
            // Needs to be turned into byte [-127,127] and added to bytes[]
            while ((readByte = byteReader.read()) != -1)
            {
                ram[i] = (byte) readByte;
                i++;
            }

            byteReader.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void printRAM()
    {
        int l = 0;
        for (byte i : ram)
        {
            System.out.print(hex.toHexDigits(i) + " ");
            l++;
            if (l > 15)
            {
                l = 0;
                System.out.print("\n");
            }
        }
    }
}
