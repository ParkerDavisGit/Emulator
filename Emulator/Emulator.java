package Emulator;

import Emulator.Assembly.AssemblyCompiler;
import Emulator.Assembly.AssemblyEmulator;

public class Emulator
{
    static AssemblyEmulator assemblyEmulator = new AssemblyEmulator();
    static AssemblyCompiler assemblyCompiler = new AssemblyCompiler();


    public static void main(String[] args)
    {
        System.out.println("Program Started");
        assemblyEmulator.read("1");
        //assemblyEmulator.printRAM();
        assemblyEmulator.parseNext();
    }
}
