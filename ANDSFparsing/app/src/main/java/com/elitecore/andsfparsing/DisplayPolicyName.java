/**
 * Created by Ashish on 04/07/2015.
 */


package com.elitecore.andsfparsing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.elitecorelib.andsf.api.ANDSFTask;
import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.pojo.PolicyInformation;
import com.elitecorelib.andsf.utility.CustomConstant;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


public class DisplayPolicyName extends Activity {

    private Timer autoUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_policy_name);
        displayPolicy();
    }

    /*public void onResume(){
        super.onResume();
        autoUpdate = new Timer();
        autoUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayPolicy();
                    }
                });
            }
        }, 0, 40000);  // updates each 40 secs
    }

    public void onPause(){
        autoUpdate.cancel();
        super.onPause();
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_policy_name, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayPolicy(){

        Vector<Policy> policyVector = new Vector<Policy>();
        for (int i=0; i<PolicyInformation.getPolicyInformation().getSizePolicy(); i++){
            policyVector.add(i,PolicyInformation.getPolicyInformation().getPolicyObject(i));
        }
        TextView policy = (TextView) findViewById(R.id.display_policy);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<policyVector.size(); i++){
            String prefix = "";
            sb.append(prefix);
            sb.append(i + 1 + ". " + policyVector.elementAt(i).policyName + "\n");
        }
        policy.setText(sb.toString());

    }

}
