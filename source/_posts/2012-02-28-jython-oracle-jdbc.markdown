---
layout: post
title: "Jython, Oracle and JDBC"
date: 2012-02-28 08:21
comments: true
categories: jython python howto
---

I recently had the need to access a new table in an existing oracle database
using Jython.  I needed to atomically increase a field in for **one** row.

Here is what I came up with.

<!-- more -->

Notes
-----

- The demo code relies on a existing table 'NXTEST' in oracle.  I used navicat lite
  to create this table.

- The demo code locks a table row using 'select ... for update' to atomically increase
  the SEQ column.  

- The requirement was that I could have a huge number of `name` entries,
  all slightly different, each needing a separate counter.  I did'nt want
  to create a `sequence` for each of them.

Gotchas
-------

- Apparently oracle *needs* upper cased table and column names.

- I could not get oci connections to work.  This seems to be a [bug in 10.2] [1]

- Because of a bug in Jython 2.5.2 wrt `__import__` I could not get
  SQLAlchemy to work.

{% include_code jython-oracle-jdbs.py python/jdbc-oracle.py lang:python %}

[1]:  https://forums.oracle.com/forums/thread.jspa?threadID=1080064  "bug in 10.2"

