package Emulator.Assembly;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HexFormat;

public class AssemblyEmulator
{
    static HexFormat hex = HexFormat.of();

    public byte A = 0;
    public byte X = 0;
    public byte Y = 0;
    public byte[] PC = {0, 0};

    // PROGRAM RAM
    byte[] ram = new byte[320];

    public AssemblyEmulator()
    {
        System.out.println("6502 Emulator Created");
    }

    public void run()
    {
        System.out.println("6502 Asslemly Ran");
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
                if (i >= 320)
                    break;
            }

            byteReader.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Parse opcode and return a string of data
    public void parseNext()
    {
        System.out.println(hex.toHexDigits(PC[0]));
        // A9 - LDA # - Load Accumulator Immediate
        switch (hex.toHexDigits(ram[bytesToInt(PC[1], PC[0])])) {
            case "4c":
                OPCODE_LDA_I();
                incrementPC(3);
                OPCODE_LDA_I();
                break;
        
            default:
                break;
        }
    }

    // Given 2 bytes, return an int value
    // [byte1][byte2] read as hex value into int
    public int bytesToInt(byte one, byte two)
    {
        return (one & 0xff) << 8 | (two & 0xff);
    }

    // Increments the PC by a set amount
    public void incrementPC(int times)
    {
        // Will generally be either 1 or 3 times
        for (int i = 0; i < times; i++)
        {
            System.out.println(hex.toHexDigits(PC[1]) + hex.toHexDigits(PC[0]));
            // First, see if the first digit will overflow.
            if (PC[0] == -1)
                PC[1]++;
            // If it does overflow, it'll reset back to 0 by itself
            PC[0]++;
        }
    }

    // Displays all the ram in memory
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
    
    /// OPCODE ZONE ///
    public void OPCODE_LDA_I()
    {
        System.out.println(bytesToInt(PC[1], PC[0]) + " " + ram[bytesToInt(PC[1], PC[0])]);
    }
}
