import java.util.LinkedList;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.mule.util.CaseInsensitiveHashMap;

public class Pause implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
//		CaseInsensitiveHashMap cihm = (CaseInsensitiveHashMap) 
//		System.out.println("");
//		Long mlid =  (Long) tmp.get("MAILING_LIST_ID");
//		Long mid =  (Long) tmp.get("MESSAGE_ID");
//		eventContext.getMessage().setInvocationProperty("mlid", mlid);
//		eventContext.getMessage().setInvocationProperty("mid", mid);
//		eventContext.getMessage().getInvocationProperty("", PropertyScope.INVOCATION)
		Object cihm = eventContext.getMessage().getPayload();
		return cihm;
	}

}
