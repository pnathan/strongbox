# strongbox

A GUI for symmetric encryption using GPG.

**BETA**

## Cautions

Security level is MEH.

This is perhaps good enough to defeat stupid criminals and people not
skilled in IT. It uses symmetric encryption; the same password both
locks and unlocks the file. This is subject to certain classes of
attacks that are very easy to carry out by a competent cracker.

Also, you will need to select a good password (passphrase) and then not
forget it, which is harder than it sounds.

In short, if you have significant value in your files, pay a competent
security engineer to put together a significantly good security
solution. In all likelyhood, Strongbox will be **junked**.

But if you do *not* have significant value in your files, i.e., they
are personal memorabilia and not subject to skilled cracking,
Strongbox should be just fine for your needs. Probably. :-)

## Usage

### Compilation

Compile with `lein uberjar`.

### Running

Double click the standalone jar file and use the simple gui to encrypt your files.

Note that GPG will leave your original file still present on your disk.

## License

Copyright © 2013 Paul Nathan

Distributed under the AGPL3 license.
