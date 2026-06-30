package com.ztec.bsp.zbcr;

public class ZBarcodeReader {

    static {
        System.loadLibrary("zbcr");
    }

    public ZBarcodeReader() {}

    public native byte[] ZBCR_ReadDecode(int timeout);
    public native int ZBCR_Open(String comAddres, int baudRate);
    public native void ZBCR_Close();
    public native int ZBCR_StartScan();
    public native int ZBCR_StopScan();
    public native int ZBCR_Led(int setNo);
    public native int ZBCR_LocationLed(int setNo);
    public native int ZBCR_ScanModel(int setNo);
    public native int ZBCR_BSPCommand(byte[] pInputBuffer, byte[] pOutputBuffer, Integer OutreturnLen);
}