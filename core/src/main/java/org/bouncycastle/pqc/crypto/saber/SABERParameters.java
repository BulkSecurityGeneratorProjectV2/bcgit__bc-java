package org.bouncycastle.pqc.crypto.saber;

import org.bouncycastle.crypto.CipherParameters;

public class SABERParameters
    implements CipherParameters
{

    public static final SABERParameters lightsaberkem128r3 = new SABERParameters("lightsaberkem128r3", 2, 128);
    public static final SABERParameters saberkem128r3 = new SABERParameters("saberkem128r3", 3, 128);
    public static final SABERParameters firesaberkem128r3 = new SABERParameters("firesaberkem128r3", 4, 128);

    public static final SABERParameters lightsaberkem192r3 = new SABERParameters("lightsaberkem192r3", 2, 192);
    public static final SABERParameters saberkem192r3 = new SABERParameters("saberkem192r3", 3, 192);
    public static final SABERParameters firesaberkem192r3 = new SABERParameters("firesaberkem192r3", 4, 192);

    public static final SABERParameters lightsaberkem256r3 = new SABERParameters("lightsaberkem256r3", 2, 256);
    public static final SABERParameters saberkem256r3 = new SABERParameters("saberkem256r3", 3, 256);
    public static final SABERParameters firesaberkem256r3 = new SABERParameters("firesaberkem256r3", 4, 256);

    private final String name;
    private final int l;
    private final int defaultKeySize;
    private final SABEREngine engine;

    public SABERParameters(String name, int l, int defaultKeySize)
    {
        this.name = name;
        this.l = l;
        this.defaultKeySize = defaultKeySize;
        this.engine = new SABEREngine(l, defaultKeySize);
    }

    public String getName()
    {
        return name;
    }

    public int getL()
    {
        return l;
    }

    public int getSessionKeySize()
    {
        return defaultKeySize;
    }

    public SABEREngine getEngine()
    {
        return engine;
    }
}
