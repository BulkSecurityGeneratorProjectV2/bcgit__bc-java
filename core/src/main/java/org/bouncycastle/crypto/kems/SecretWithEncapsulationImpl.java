package org.bouncycastle.crypto.kems;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.security.auth.DestroyFailedException;

import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.util.Arrays;

class SecretWithEncapsulationImpl
    implements SecretWithEncapsulation
{
    private final AtomicBoolean hasBeenDestroyed = new AtomicBoolean(false);

    private final byte[] sessionKey;
    private final byte[] cipher_text;

    public SecretWithEncapsulationImpl(byte[] sessionKey, byte[] cipher_text)
    {
        this.sessionKey = sessionKey;
        this.cipher_text = cipher_text;
    }

    public byte[] getSecret()
    {
        checkDestroyed();

        return Arrays.clone(sessionKey);
    }

    public byte[] getEncapsulation()
    {
        checkDestroyed();

        return Arrays.clone(cipher_text);
    }

    public void destroy()
        throws DestroyFailedException
    {
        if (!hasBeenDestroyed.getAndSet(true))
        {
            Arrays.clear(sessionKey);
            Arrays.clear(cipher_text);
        }
    }

    public boolean isDestroyed()
    {
        return hasBeenDestroyed.get();
    }

    void checkDestroyed()
    {
        if (isDestroyed())
        {
            throw new IllegalStateException("data has been destroyed");
        }
    }
}
