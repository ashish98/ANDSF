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

public class Circular extends AttributeContainer implements KvmSerializable,Serializable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String latitude;
    
    public String longitude;
    
    public String radius;

    public Circular ()
    {
    }

    public Circular (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("latitude"))
        {	
	        java.lang.Object obj = soapObject.getProperty("latitude");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.latitude = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.latitude = (String)obj;
            }    
        }
        if (soapObject.hasProperty("longitude"))
        {	
	        java.lang.Object obj = soapObject.getProperty("longitude");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.longitude = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.longitude = (String)obj;
            }    
        }
        if (soapObject.hasProperty("radius"))
        {	
	        java.lang.Object obj = soapObject.getProperty("radius");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.radius = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.radius = (String)obj;
            }    
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.latitude!=null?this.latitude:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.longitude!=null?this.longitude:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.radius!=null?this.radius:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "latitude";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "longitude";
            info.namespace= "";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "radius";
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