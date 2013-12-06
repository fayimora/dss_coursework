## Distributed Systems Coursework 1

### How to run

To run the server, first run `rmiregistry` on a seperate terminal session. You can use `rmiregistry
&` to run in the background. Keep a note of the PID s you can kill it later. To kill the process,
run `kill -9 PID` in the terminal.

Start the server on another terminal with `javac BankServerImpl.java && java BankServerImpl`
Start the client with `javac Client.java && java Client IP_ADDRESS 1099`

Enjoy!



Distributed Systems Coursework 1
Copyright (C) 2013 Fayimora Femi-Balogun

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


