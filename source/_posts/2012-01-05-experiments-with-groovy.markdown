---
layout: post
title: experiments with groovy
date: 2012-01-05 17:30
comments: false
categories: groovy code
published: true
---

In my constant task to hone and resharpen my tools, I've started some experiments
with **groovy**.

Groovy is a scripting language which runs on top of the *JVM* like *Jython* or *jRuby*.  But
unlike other scripting languages, **groovy** classes are full-blown Java classes and can be used
within plain Java.  Also, any Java package can be used in groovy without writing bridges and
stuff.

Also it seems that **groovy** fits my python and coffee-script infested brain better than the more
modern and hip cousins **clojure** and **scala**.

So what does it look like?  Grok this:

{% include_code maps, adding and iterating over items groovy/mapkeys.groovy lang:java %}

(note: I did'nt succeed in getting the groovy lexer running in pygments and octopress, so
no syntax coloring. oh well.)

This looks pretty readable to me!

classes, closures, iterators -- oh my
-------------------------------------

**groovy** is fully OO -- grok this:

{% include_code maps, adding and iterating over items groovy/mapkeys.groovy lang:java %}

The block enclosed in curly braces is a *closure*.  They're objects, too:

{% include_code fun with closures groovy/closure.groovy lang:java %}

Another nice thing is how classes are defined and how **groovy** creates automatic
constructors:

{% include_code classes and constructors groovy/class.groovy lang:java %}

Notice how we did **not** need to specify getter and setter methods.  Also notice
how **groovy** uses named arguments!

What's next?
------------

Well.  Next up, I'll try to get some `PDMlink` stuff working with **groovy**.

Links
-----

You can find **groovy** documentation at [codehaus] [1].  There's also a zone
over at [dzone] [2].

  [1]: http://groovy.codehaus.org/      "Groovy at codehaus"
  [2]: http://groovy.dzone.com/  	"Groovy Zone


