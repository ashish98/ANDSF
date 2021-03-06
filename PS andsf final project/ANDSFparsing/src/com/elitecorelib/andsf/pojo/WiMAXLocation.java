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

public class WiMAXLocation extends AttributeContainer implements KvmSerializable,Serializable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String BS_ID;
    
    public String NAP_ID;

    public WiMAXLocation ()
    {
    }

    public WiMAXLocation (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("BS_ID"))
        {	
	        java.lang.Object obj = soapObject.getProperty("BS_ID");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.BS_ID = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.BS_ID = (String)obj;
            }    
        }
        if (soapObject.hasProperty("NAP_ID"))
        {	
	        java.lang.Object obj = soapObject.getProperty("NAP_ID");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.NAP_ID = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.NAP_ID = (String)obj;
            }    
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.BS_ID!=null?this.BS_ID:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.NAP_ID!=null?this.NAP_ID:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "BS_ID";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "NAP_ID";
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
}
