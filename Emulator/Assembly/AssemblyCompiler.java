package Emulator.Assembly;

import java.io.File;
import java.util.HexFormat;
import java.io.InputStream;
import java.io.FileInputStream;

public class AssemblyCompiler
{
    static HexFormat hex = HexFormat.of();

    

    public AssemblyCompiler()
    {
        byte test = -120;
        System.out.println(hex.toHexDigits(test));
    }
    
    
}
