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

public class ValidityArea extends AttributeContainer implements KvmSerializable,Serializable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList< Geo_Location_1>geo_Location_ =new ArrayList<Geo_Location_1>();
    
    public ArrayList< Location3GPP>location_3GPP =new ArrayList<Location3GPP>();
    
    public ArrayList< Location3GPP2>location_3GPP2 =new ArrayList<Location3GPP2>();
    
    public String RPLMN;
    
    public ArrayList< WlanLocation>WLAN_Location =new ArrayList<WlanLocation>();
    
    public ArrayList< WiMAXLocation>wiMAX_Location =new ArrayList<WiMAXLocation>();

    public ValidityArea ()
    {
    }

    public ValidityArea (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("geo_Location_"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.geo_Location_ = new ArrayList<Geo_Location_1>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("geo_Location_"))
	            {
                    java.lang.Object j =info.getValue();
	                Geo_Location_1 j1= new Geo_Location_1(j,__envelope);
	                this.geo_Location_.add(j1);
	            }
	        }
        }
        if (soapObject.hasProperty("location_3GPP"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.location_3GPP = new ArrayList<Location3GPP>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("location_3GPP"))
	            {
                    java.lang.Object j =info.getValue();
	                Location3GPP j1= (Location3GPP)__envelope.get(j,Location3GPP.class);
	                this.location_3GPP.add(j1);
	            }
	        }
        }
        if (soapObject.hasProperty("location_3GPP2"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.location_3GPP2 = new ArrayList<Location3GPP2>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("location_3GPP2"))
	            {
                    java.lang.Object j =info.getValue();
	                Location3GPP2 j1= (Location3GPP2)__envelope.get(j,Location3GPP2.class);
	                this.location_3GPP2.add(j1);
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
        if (soapObject.hasProperty("WLAN_Location"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.WLAN_Location = new ArrayList<WlanLocation>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("WLAN_Location"))
	            {
                    java.lang.Object j =info.getValue();
	                WlanLocation j1= (WlanLocation)__envelope.get(j,WlanLocation.class);
	                this.WLAN_Location.add(j1);
	            }
	        }
        }
        if (soapObject.hasProperty("wiMAX_Location"))
        {	
	        int size = soapObject.getPropertyCount();
	        this.wiMAX_Location = new ArrayList<WiMAXLocation>();
	        for (int i0=0;i0< size;i0++)
	        {
	            PropertyInfo info=new PropertyInfo();
	            soapObject.getPropertyInfo(i0, info);
                java.lang.Object obj = info.getValue();
	            if (obj!=null && info.name.equals("wiMAX_Location"))
	            {
                    java.lang.Object j =info.getValue();
	                WiMAXLocation j1= (WiMAXLocation)__envelope.get(j,WiMAXLocation.class);
	                this.wiMAX_Location.add(j1);
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
            return this.RPLMN!=null?this.RPLMN:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=+1 && propertyIndex< + 1+this.geo_Location_.size())
        {
            return this.geo_Location_.get(propertyIndex-(+1));
        }
        if(propertyIndex>=+1+this.geo_Location_.size() && propertyIndex< + 1+this.geo_Location_.size()+this.location_3GPP.size())
        {
            return this.location_3GPP.get(propertyIndex-(+1+this.geo_Location_.size()));
        }
        if(propertyIndex>=+1+this.geo_Location_.size()+this.location_3GPP.size() && propertyIndex< + 1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size())
        {
            return this.location_3GPP2.get(propertyIndex-(+1+this.geo_Location_.size()+this.location_3GPP.size()));
        }
        if(propertyIndex>=+1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size() && propertyIndex< + 1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size())
        {
            return this.WLAN_Location.get(propertyIndex-(+1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()));
        }
        if(propertyIndex>=+1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size() && propertyIndex< + 1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size()+this.wiMAX_Location.size())
        {
            return this.wiMAX_Location.get(propertyIndex-(+1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size()));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+geo_Location_.size()+location_3GPP.size()+location_3GPP2.size()+WLAN_Location.size()+wiMAX_Location.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RPLMN";
            info.namespace= "";
        }
        if(propertyIndex>=+1 && propertyIndex <= +1+this.geo_Location_.size())
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "geo_Location_";
            info.namespace= "";
        }
        if(propertyIndex>=+1+this.geo_Location_.size() && propertyIndex <= +1+this.geo_Location_.size()+this.location_3GPP.size())
        {
            info.type = Location3GPP.class;
            info.name = "location_3GPP";
            info.namespace= "";
        }
        if(propertyIndex>=+1+this.geo_Location_.size()+this.location_3GPP.size() && propertyIndex <= +1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size())
        {
            info.type = Location3GPP2.class;
            info.name = "location_3GPP2";
            info.namespace= "";
        }
        if(propertyIndex>=+1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size() && propertyIndex <= +1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size())
        {
            info.type = WlanLocation.class;
            info.name = "WLAN_Location";
            info.namespace= "";
        }
        if(propertyIndex>=+1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size() && propertyIndex <= +1+this.geo_Location_.size()+this.location_3GPP.size()+this.location_3GPP2.size()+this.WLAN_Location.size()+this.wiMAX_Location.size())
        {
            info.type = WiMAXLocation.class;
            info.name = "wiMAX_Location";
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
		return "ValidityArea [geo_Location_=" + geo_Location_
				+ ", location_3GPP=" + location_3GPP + ", location_3GPP2="
				+ location_3GPP2 + ", RPLMN=" + RPLMN + ", WLAN_Location="
				+ WLAN_Location + ", wiMAX_Location=" + wiMAX_Location + "]";
	}
}