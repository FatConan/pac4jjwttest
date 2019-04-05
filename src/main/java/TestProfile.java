import org.pac4j.core.profile.CommonProfile;

import java.util.*;

public class TestProfile extends CommonProfile{
    private boolean enableTableAwareness = false;
    private Map<String, Object> additionalData = new HashMap<>();
    private boolean anonymous = false;
    private boolean proxy = false;

    public boolean isEnableTableAwareness(){
        return enableTableAwareness;
    }

    public void setEnableTableAwareness(boolean enableTableAwareness){
        this.enableTableAwareness = enableTableAwareness;
    }

    public Map<String, Object> getAdditionalData(){
        return additionalData;
    }

    public void setAdditionalData(Map<String, Object> additionalData){
        this.additionalData = additionalData;
    }

    public boolean isAnonymous(){
        return anonymous;
    }

    public void setAnonymous(boolean anonymous){
        this.anonymous = anonymous;
    }

    public boolean isProxy(){
        return proxy;
    }

    public void setProxy(boolean proxy){
        this.proxy = proxy;
    }
}
