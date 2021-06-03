package com.sourcegrounds;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.NamingException;
import com.sun.jndi.ldap.spi.LdapDnsProvider;
import com.sun.jndi.ldap.spi.LdapDnsProviderResult;

public class MyLdapDnsProvider
    extends LdapDnsProvider
{
    @Override
    public Optional<com.sun.jndi.ldap.spi.LdapDnsProviderResult> lookupEndpoints( String url, Map<?, ?> env )
        throws NamingException
    {
        return null;
    }

    public Optional<Result> findEndpoints( String url, Map<?, ?> env )
        throws NamingException
    {
        return lookupEndpoints( url, env ).map( MyLdapDnsProvider::map );
    }

    private static Result map( final com.sun.jndi.ldap.spi.LdapDnsProviderResult result )
    {
        return new Result()
        {
            @Override
            public List<String> getEndpoints()
            {
                return result.getEndpoints();
            }

            @Override
            public String getDomainName()
            {
                return result.getDomainName();
            }
        };
    }

}
