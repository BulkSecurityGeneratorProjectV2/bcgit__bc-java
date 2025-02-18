package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;

import org.bouncycastle.pqc.jcajce.spec.SIKEParameterSpec;

public interface SIKEKey
    extends Key
{
    /**
     * Return the parameters for this key.
     *
     * @return a SIKEParameterSpec
     */
    SIKEParameterSpec getParameterSpec();
}
