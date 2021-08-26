import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.naming.ldap.PagedResultsControl;
import javax.naming.ldap.PagedResultsResponseControl;

public class LdapSearchServer {

	private LdapContext ctx = null;
	
	public LdapSearchServer() throws Exception {
		Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://ad01.server.com:389");
		env.put(Context.SECURITY_PRINCIPAL, "ad_binduser" + "@domain.com"); // userPrincipalName
//		env.put(Context.SECURITY_PRINCIPAL, "CN=(TD5012),OU=Tech ,OU= ,OU= ,OU= ,DC=domaninsecurity,DC=local"); // distinguishedName
		env.put(Context.SECURITY_CREDENTIALS, "password");
		
		ctx = new InitialLdapContext(env, null);
		
		// Adding ShutdownHook
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					ctx.close();
				} catch (NamingException e) { }
			}
		});
	}
	
	public void start() throws Exception {
		int pageSize = 1000;
		
		String baseDN = "OU=bdp,OU=admingroup, DC=serverad,DC=local";
		String searchFilter = "(&(objectClass=user))";
		//String searchFilter = "(&(objectClass=group))";

		SearchControls sc = new SearchControls();
		sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
		sc.setReturningAttributes(new String[]{
				"distinguishedName",
				"objectClass",
				"department",
				"departmentNumber",
				"userPrincipalName",
				"sAMAccountName",
				"displayName",
				"cn",
				"title",
				"mail",
				"company",
				"name",
				"description",
				"employeeID",
				"employeeNumber",
				"memberOf",
				"member",
        "status"
		});

		byte[] cookie = null;
		int total = 0;

		ctx.setRequestControls(new Control[]{ new PagedResultsControl(pageSize, Control.NONCRITICAL)});
		
		do {
			NamingEnumeration<SearchResult> results = ctx.search(baseDN, searchFilter, sc);
			while (results.hasMoreElements()) {
				total++;
				SearchResult result = results.nextElement();
				Attributes attrs = result.getAttributes();
//				System.out.println(attrs);

				StringBuilder sb = new StringBuilder();
				NamingEnumeration<? extends Attribute> enumer = attrs.getAll();
				while (enumer.hasMoreElements()) {
					Attribute attr = enumer.nextElement();
					sb.append('|').append(attr);
				}
				System.out.println(sb.substring(1));
				
//				sb.append('|').append(attrs.get("description"));
//				sb.append('|').append(attrs.get("distinguishedName"));
//				
			}

			Control[] controls = ctx.getResponseControls();
			if (controls != null) {
				PagedResultsResponseControl prrc = (PagedResultsResponseControl)controls[0];
				cookie = prrc.getCookie();
				
				ctx.setRequestControls(new Control[]{ new PagedResultsControl(pageSize, cookie, Control.CRITICAL)});
			}
			
		} while (cookie != null);
		
		System.out.println(String.format("Total: %,d", total));
		
		
	}
	
	public static void main(String[] args) throws Exception {
		LdapSearchServer ldap = new LdapSearchServer();
		ldap.start();
	}

}

