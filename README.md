# HS110

Library for reading a TPLink HS110 Smart Plug

## Example Usage:

Include as a dependency in pom.xml (or equivalent if not using maven):

    <dependency>
        <groupId>dev.rablet</groupId>
        <artifactId>hs110</artifactId>
        <version>0.0.1</version>
    </dependency>

Import in your class:

    import dev.rablet.hs110.HS110Client;
    import dev.rablet.hs110.model.Realtime;

Then fetch data:

    HS110Client hs110 = new HS110Client("<ip-or-hostname-here>");

    Realtime hs110Realtime = hs110.getRealtime();
    System.out.println(hs110Realtime);

Sample output:

    { voltage='241.516', current='0.017', power='0.0', total='0.679', errCode='0'}
