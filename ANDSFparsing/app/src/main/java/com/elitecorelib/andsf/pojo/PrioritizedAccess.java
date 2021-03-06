package com.elitecorelib.andsf.pojo;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.1.4.2
//
// Created by Quasar Development at 04-03-2015
//
//---------------------------------------------------


import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.*;

import com.elitecorelib.andsf.exception.InvalidDataException;
import com.elitecorelib.andsf.utility.CustomConstant;
import com.elitecorelib.andsf.utility.CustomMessage;

import android.util.Log;

public class PrioritizedAccess extends AttributeContainer implements KvmSerializable,Comparable<PrioritizedAccess>,Serializable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String accessId;
    
    public Integer accessNetworkPriority=0;
    
    public Integer accessTechnology=0;
    
    public String secondaryAccessId;

    public PrioritizedAccess ()
    {
    }

    public PrioritizedAccess (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("accessId"))
        {	
	        java.lang.Object obj = soapObject.getProperty("accessId");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.accessId = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.accessId = (String)obj;
            }    
        }
        if (soapObject.hasProperty("accessNetworkPriority"))
        {	
	        java.lang.Object obj = soapObject.getProperty("accessNetworkPriority");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.accessNetworkPriority = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.accessNetworkPriority = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("accessTechnology"))
        {	
	        java.lang.Object obj = soapObject.getProperty("accessTechnology");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.accessTechnology = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.accessTechnology = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("secondaryAccessId"))
        {	
	        java.lang.Object obj = soapObject.getProperty("secondaryAccessId");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.secondaryAccessId = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.secondaryAccessId = (String)obj;
            }    
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.accessId!=null?this.accessId:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return accessNetworkPriority;
        }
        if(propertyIndex==2)
        {
            return accessTechnology;
        }
        if(propertyIndex==3)
        {
            return this.secondaryAccessId!=null?this.secondaryAccessId:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "accessId";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "accessNetworkPriority";
            info.namespace= "";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "accessTechnology";
            info.namespace= "";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "secondaryAccessId";
            info.namespace= "";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }

	@Override
	public String toString() {
		return "PrioritizedAccess [accessId=" + accessId
				+ "\n accessNetworkPriority=" + accessNetworkPriority
				+ "\n accessTechnology=" + accessTechnology
				+ "\n secondaryAccessId=" + secondaryAccessId + "]";
	}

	@Override
	public int compareTo(PrioritizedAccess another) {
		int returnVal = 0;
		
		if(this.accessNetworkPriority < another.accessNetworkPriority){
			returnVal = 1;
		}else if(this.accessNetworkPriority == another.accessNetworkPriority){
			returnVal = 0;
		}else{
			returnVal = -1;
		}
		return returnVal;
	}

	//public void validate() throws InvalidDataException {
    public boolean validate(){
		Log.d(CustomConstant.ApplicationTag,"Prioritized Access validation is started "+this.toString());
		
		//First validate Access Technology
		//If access technology Mentioned as WLAN :3 then either access id or secondary accessid is mandatory.
		if(this.accessTechnology!=1 && this.accessTechnology!=3 && this.accessTechnology!=4){
			//throw new InvalidDataException(CustomMessage.invalidAccessTechnology);
            return false;
		}
				
		//Access Network priority should be between 1-250 and 254 and 255.
		// Other value is considered to be invalid.
		if(this.accessNetworkPriority <= 0 || this.accessNetworkPriority >255){
			//throw new InvalidDataException(CustomMessage.invalidAccessNetworkPriority);
            return false;
		}
		
		if(this.accessNetworkPriority > 250 && this.accessNetworkPriority > 254){
			//throw new InvalidDataException(CustomMessage.invalidAccessNetworkPriority);
            return false;
		}
        else {
            return true;
        }
		
	}
}
