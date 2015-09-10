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
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class UeLocation extends AttributeContainer implements KvmSerializable,Serializable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Geo_Location geoLocation;
    
    public ArrayList< Location3GPP>location_3gpp =new ArrayList<Location3GPP>();
    
    public ArrayList< Location3GPP2>location_3gpp2 =new ArrayList<Location3GPP2>();
    
    public String RPLMN;
    
    public ArrayList< WiMAXLocation>wimaxLocation =new ArrayList<WiMAXLocation>();
    
    public ArrayList< WlanLocation>wlanLocation =new ArrayList<WlanLocation>();

    public UeLocation ()
    {
    }

    public UeLocation (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("geoLocation"))
        {	
	        java.lang.Object j = soapObject.getProperty("geoLocation");
	        this.geoLocation = (Geo_Location)__envelope.get(j,Geo_Location.class);
        }
        if (soapObject.hasProperty("location_3gpp"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.location_3gpp = new ArrayList<Location3GPP>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("location_3gpp"))
	            {
                    java.lang.Object j =info.getValue();
	                Location3GPP j1= (Location3GPP)__envelope.get(j,Location3GPP.class);
	                this.location_3gpp.add(j1);
	            }
	        }
        }
        if (soapObject.hasProperty("location_3gpp2"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.location_3gpp2 = new ArrayList<Location3GPP2>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("location_3gpp2"))
	            {
                    java.lang.Object j =info.getValue();
	                Location3GPP2 j1= (Location3GPP2)__envelope.get(j,Location3GPP2.class);
	                this.location_3gpp2.add(j1);
	            }
	        }
        }
        if (soapObject.hasProperty("RPLMN"))
        {	
	        java.lang.Object obj = soapObject.getProperty("RPLMN");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.RPLMN = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.RPLMN = (String)obj;
            }    
        }
        if (soapObject.hasProperty("wimaxLocation"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.wimaxLocation = new ArrayList<WiMAXLocation>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("wimaxLocation"))
	            {
                    java.lang.Object j =info.getValue();
	                WiMAXLocation j1= (WiMAXLocation)__envelope.get(j,WiMAXLocation.class);
	                this.wimaxLocation.add(j1);
	            }
	        }
        }
        if (soapObject.hasProperty("wlanLocation"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.wlanLocation = new ArrayList<WlanLocation>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("wlanLocation"))
	            {
                    java.lang.Object j =info.getValue();
	                WlanLocation j1= (WlanLocation)__envelope.get(j,WlanLocation.class);
	                this.wlanLocation.add(j1);
	            }
	        }
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.geoLocation!=null?this.geoLocation:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.RPLMN!=null?this.RPLMN:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=+2 && propertyIndex< + 2+this.location_3gpp.size())
        {
            return this.location_3gpp.get(propertyIndex-(+2));
        }
        if(propertyIndex>=+2+this.location_3gpp.size() && propertyIndex< + 2+this.location_3gpp.size()+this.location_3gpp2.size())
        {
            return this.location_3gpp2.get(propertyIndex-(+2+this.location_3gpp.size()));
        }
        if(propertyIndex>=+2+this.location_3gpp.size()+this.location_3gpp2.size() && propertyIndex< + 2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size())
        {
            return this.wimaxLocation.get(propertyIndex-(+2+this.location_3gpp.size()+this.location_3gpp2.size()));
        }
        if(propertyIndex>=+2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size() && propertyIndex< + 2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size()+this.wlanLocation.size())
        {
            return this.wlanLocation.get(propertyIndex-(+2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size()));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+location_3gpp.size()+location_3gpp2.size()+wimaxLocation.size()+wlanLocation.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = Geo_Location.class;
            info.name = "geoLocation";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RPLMN";
            info.namespace= "";
        }
        if(propertyIndex>=+2 && propertyIndex <= +2+this.location_3gpp.size())
        {
            info.type = Location3GPP.class;
            info.name = "location_3gpp";
            info.namespace= "";
        }
        if(propertyIndex>=+2+this.location_3gpp.size() && propertyIndex <= +2+this.location_3gpp.size()+this.location_3gpp2.size())
        {
            info.type = Location3GPP2.class;
            info.name = "location_3gpp2";
            info.namespace= "";
        }
        if(propertyIndex>=+2+this.location_3gpp.size()+this.location_3gpp2.size() && propertyIndex <= +2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size())
        {
            info.type = WiMAXLocation.class;
            info.name = "wimaxLocation";
            info.namespace= "";
        }
        if(propertyIndex>=+2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size() && propertyIndex <= +2+this.location_3gpp.size()+this.location_3gpp2.size()+this.wimaxLocation.size()+this.wlanLocation.size())
        {
            info.type = WlanLocation.class;
            info.name = "wlanLocation";
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
