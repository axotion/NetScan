package com.evilnet.axo.netscan;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
public class MainActivity extends AppCompatActivity {
    static public String[] netmask_list;
    public String[] ip_for;
    public long start;
    public long end;
    public long elapsedTime;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void show_message(final String title, final String text, final int exit){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(title)
                            .setMessage(text)
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                if(exit == 1)
                                    System.exit(0);

                                }
                            }).create().show();
                }
            }
        });
    }
    public void scan_network(int ip, int netmask){
        //fix this
        int ip_count ;
        int lock = 0;
        netmask_list = new String[30];
        netmask_list[0] = "128.0.0.0";
        netmask_list[1] = "192.0.0.0";
        netmask_list[2] = "224.0.0.0";
        netmask_list[3] = "240.0.0.0";
        netmask_list[4] = "248.0.0.0";
        netmask_list[5] = "252.0.0.0";
        netmask_list[6] = "254.0.0.0";
        netmask_list[7] = "255.0.0.0";
        netmask_list[8] = "255.128.0.0";
        netmask_list[9] = "255.192.0.0";
        netmask_list[10] = "255.224.0.0";
        netmask_list[11] = "255.240.0.0";
        netmask_list[12] = "255.248.0.0";
        netmask_list[13] = "255.252.0.0";
        netmask_list[14] = "255.254.0.0";
        netmask_list[15] = "255.255.0.0";
        netmask_list[16] = "255.255.128.0";
        netmask_list[17] = "255.255.192.0";
        netmask_list[18] = "255.255.224.0";
        netmask_list[19] = "255.255.240.0";
        netmask_list[20] = "255.255.248.0";
        netmask_list[21] = "255.255.252.0";
        netmask_list[22] = "255.255.254.0";
        netmask_list[23] = "255.255.255.0";
        netmask_list[24] = "255.255.255.128";
        netmask_list[25] = "255.255.255.192";
        netmask_list[26] = "255.255.255.224";
        netmask_list[27] = "255.255.255.240";
        netmask_list[28] = "255.255.255.248";
        netmask_list[29] = "255.255.255.252";
        String gw_ip =  Formatter.formatIpAddress(ip);
        String netmask_ip =  Formatter.formatIpAddress(netmask);
        if(Objects.equals(gw_ip, "0.0.0.0")){
            lock = 1;
            show_message("Error", "Turn on WiFi", 1);
        }
        if((Objects.equals(netmask_list[0], netmask_ip))) {
            ip_count=2147483646;
        }
        else if((Objects.equals(netmask_list[1], netmask_ip))) {
            ip_count=1073741822;
        }
        else if((Objects.equals(netmask_list[2], netmask_ip))) {
            ip_count=536870910;
        }
        else if((Objects.equals(netmask_list[3], netmask_ip))) {
            ip_count=268435454;
        }
        else if((Objects.equals(netmask_list[4], netmask_ip))) {
            ip_count=134217726;
        }
        else if((Objects.equals(netmask_list[5], netmask_ip))) {
            ip_count=67108862;
        }
        else if((Objects.equals(netmask_list[6], netmask_ip)) ) {
            ip_count=33554430;
        }
        else if((Objects.equals(netmask_list[7], netmask_ip))) {
            ip_count=16777214;
        }
        else if((Objects.equals(netmask_list[8], netmask_ip))) {
            ip_count=8388606;
        }
        else if((Objects.equals(netmask_list[9], netmask_ip))) {
            ip_count=4194302;
        }
        else if((Objects.equals(netmask_list[10], netmask_ip))) {
            ip_count=2097150;
        }
        else if((Objects.equals(netmask_list[11], netmask_ip))) {
            ip_count=1048574;
        }
        else if((Objects.equals(netmask_list[12], netmask_ip))) {
            ip_count=524286;
        }
        else if((Objects.equals(netmask_list[13], netmask_ip))) {
            ip_count=262142;
        }
        else if((Objects.equals(netmask_list[14], netmask_ip))) {
            ip_count=131070;
        }
        else if((Objects.equals(netmask_list[15], netmask_ip))) {
            ip_count=65534;
        }
        else if((Objects.equals(netmask_list[16], netmask_ip))) {
            ip_count=32766;
        }
        else if((Objects.equals(netmask_list[17], netmask_ip))) {
            ip_count=16382;
        }
        else if((Objects.equals(netmask_list[18], netmask_ip))) {
            ip_count=8190;
        }
        else if((Objects.equals(netmask_list[19], netmask_ip))) {
            ip_count=4094;
        }
        else if((Objects.equals(netmask_list[20], netmask_ip))) {
            ip_count=2046;
        }
        else if((Objects.equals(netmask_list[21], netmask_ip))) {
            ip_count=1022;
        }
        else if((Objects.equals(netmask_list[22], netmask_ip))) {
            ip_count=510;
        }
        else if((Objects.equals(netmask_list[23], netmask_ip))) {
            ip_count=254;
        }
        else if((Objects.equals(netmask_list[24], netmask_ip))) {
            ip_count=126;
        }
        else if((Objects.equals(netmask_list[25], netmask_ip))) {
            ip_count=62;
        }
        else if((Objects.equals(netmask_list[26], netmask_ip))) {
            ip_count=30;
        }
        else if((Objects.equals(netmask_list[27], netmask_ip))) {
            ip_count=14;
        }
        else if((Objects.equals(netmask_list[28], netmask_ip))) {
            ip_count=6;
        }
        else if((Objects.equals(netmask_list[29], netmask_ip))) {
            ip_count=2;
        }
        else{
            ip_count=0;
        }
        Log.d("Current netmask theory)", netmask_list[23]);
        Log.d("Current netmask prac)", netmask_ip);
        Log.d("GW_IP", "Value: " + gw_ip);
        Log.d("Netmask", "Value: " + netmask_ip);
        ip_for = gw_ip.split("\\.");
        int cur_ip=0;
        String full_ip="";
        try {
            Log.e("dd", String.valueOf(ip_count));
            if(lock == 0) {
                start = System.nanoTime();
                for (int i = 0; i <= ip_count; ++i) {
                    cur_ip = i;
                    InetAddress addr = InetAddress.getByName(ip_for[0] + "." + ip_for[1] + "." + ip_for[2] + "." + cur_ip);
                    if (addr.isReachable(200)) {
                        full_ip = ip_for[0] + "." + ip_for[1] + "." + ip_for[2] + "." + cur_ip;
                        final TextView txtView = (TextView) findViewById(R.id.textView2);
                        final String finalFull_ip = full_ip;
                        txtView.post(new Runnable() {
                            public void run() {
                                txtView.append(finalFull_ip + "\n");
                            }
                        });
                        end = System.nanoTime();
                        elapsedTime = end - start;
                    }
                }
                final TextView txtView = (TextView) findViewById(R.id.textView2);
                txtView.post(new Runnable() {
                    public void run() {
                        double seconds = (double)elapsedTime / 1000000000.0;
                        txtView.append("Complete in "+Math.round(seconds)+ " seconds \n");
                    }
                });
            } } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //   supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickButton = (Button) findViewById(R.id.scan_button);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread get_wifi_data = new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {
                            WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                            int IP = wifi.getDhcpInfo().gateway;
                            int NetMask = wifi.getDhcpInfo().netmask;
                            scan_network(IP, NetMask);
                        } catch (final Exception e) {
                            show_message("Error", e.getMessage(), 0);
                        }
                    }
                });
                get_wifi_data.start();
            }
        });}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent intent = new Intent(getApplicationContext(), about.class);
            startActivity(intent);
        }
        else if(id == R.id.save){
            try {
                final TextView txtView = (TextView) findViewById(R.id.textView2);
                File path = this.getFilesDir();
                File file = new File(path, "log-" + System.currentTimeMillis() + ".txt");
                PrintWriter writer = new PrintWriter(file, "UTF-8");
                writer.println(txtView.getText());
                writer.close();
                show_message("Successful", "Saved in "+path, 0);

            }
            catch (Exception e){
                show_message("Error", e.getMessage(), 0);
            }

        }
        return super.onOptionsItemSelected(item);
    }
}