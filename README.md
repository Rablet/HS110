# HS110

Library for reading a TPLink HS110 Smart Plug

## Notes

The JUnit test is currently hardcoded to test using a plug with hostname "hs110airpurifier". I will make this a config later on but for now you just need to change it in HS110Test.java

## Currently supported operations:

- getRealTime: Get power monitoring data
- getSystemInfo: Get system information
- turnOn: Turn the socket on
- turnOff: Turn the socket off

## Example Usage:

Include as a dependency in pom.xml (or equivalent if not using maven):

    <dependency>
        <groupId>dev.rablet</groupId>
        <artifactId>hs110</artifactId>
        <version>0.0.3</version>
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
