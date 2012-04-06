---
layout: post
title: "Jython, classpath and virtualenv"
date: 2012-04-06 18:26
comments: true
categories: jython python java howto
---

I finally came around to investigate some long standing issues I have
had with my Jython development environment, namely setting up the
**CLASSPATH**.

<!-- more -->

Background
----------

I use *Jython* every day to develop customizations and tools for a big,
enterprise class PLM System.  Working with this system involves setting up and
running Virtual Machines which run a stripped-down installation of the [PLM] [4]
System configured for a specific customer.

I've set up some shared folders and some terminal sessions such that I can
code using my development tools I know and love (Python, VIM and the
Terminal).

To be able to test code I develop, I want the code to run **on my local
machine**, that is, I do **not** want to click-test inside the VM, restart
tomcat and whatnot.  I just want to fire up the python REPL and get going, I
want to insert some PDB breakpoints and develop in an agile fashion.  Test
Driven, even.

The Problem
-----------

Up until recently, found that I needed to set up the **CLASSPATH** using a
environment variable for all the coding sessions I did.  I created some
wrapper scripts which deduced the correct **CLASSPATH** based on the currently
running VM, the customer project and some further guessing.

This always felt clumsy, but worked, for the most part.

At the same time, I missed the goodness of *virtualenv*, which I used to love,
which yelled to me something like:

    $ virtualenv -p jython foo                                                                                                                                                                ] 6:43 pm
    Running virtualenv with interpreter /usr/local/bin/jython
    New jython executable in foo/bin/jython
    ERROR: The executable foo/bin/jython is not functioning
    ERROR: It thinks sys.prefix is u'/usr/local/Cellar/jython/2.5.3b1/libexec' (should be u'/Users/seletz/develop/tmp/foo')
    ERROR: virtualenv is not compatible with this system or executable

Solution
--------

Now I need to confess.  I recently started looking at some IDE, because I came
across the need to code some Java for a customer project.  It seems to me,
that coding Java w/o a IDE is a hardcore PITA, thus, is started to look at
*NetBeans*, *Eclipse* and *IntelliJ* (stuff for another post).

While testing testing IDEs I also tried to set them up for Python and Jython
development.  Whatever, I found that I can have a isolated Jython environment
using *virtualenv* and w/o manually setting the **CLASSPATH**.

The error *virtualenv* gave me is simply due to the fact that I have
**JYTHON_HOME** set up in my default ... WTF [issue] [1]?


So, I just need to:

    $ cd develop/tmp
    $ unset JYTHON_HOME
    $ virtualenv -p jython customer_1


And -- lo and behold -- we have a isolated Jython environment for
*customer_1*, just like it should be.

Poking further, I noticed that the *Jython registry* is also local, and, so
is the 'site-packages' directory.  Google found a [post] [2] about setting up
the Jython *CLASSPATH*, and thus I created a 'windchill.pth' file in the
'site-packages' directory:

{% include_code windchill.pth jython/windchill.pth lang:text %}

Now I can just fire up the Jython interpreter like so:


    $ cd develop/tmp/customer_1
    $ bin/jython
    Jython 2.5.3b1 (2.5:5fa0a5810b25, Feb 22 2012, 12:39:02) 
    [Java HotSpot(TM) 64-Bit Server VM (Apple Inc.)] on java1.6.0_31
    Type "help", "copyright", "credits" or "license" for more information.
    >>> from wt.epm import EPMDocument
    >>> 


For further improvement, I can now locally manage Java dependencies using
[jip] [3].


[1]: https://github.com/pypa/virtualenv/issues/185 		"issue"
[2]: http://stackoverflow.com/questions/5839300/defining-a-classpath-for-a-jython-virtual-environment "post"
[3]: http://pypi.python.org/pypi/jip                    "jip"
[4]: http://www.ptc.com/product/windchill/pdmlink       "PLM"
