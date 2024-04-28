package Emulator.Assembly;

import java.io.File;
import java.util.HexFormat;
import java.io.InputStream;
import java.io.FileInputStream;

public class AssemblyCompiler
{
    static HexFormat hex = HexFormat.of();

    public byte A = 0;
    public byte X = 0;
    public byte Y = 0;
    public byte[] PC = {0, 0};

    public AssemblyCompiler()
    {
        byte test = -120;
        System.out.println(hex.toHexDigits(test));
    }
    
    
}
