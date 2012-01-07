---
layout: post
title: "switch from bash to zsh"
date: 2012-01-06 13:03
comments: true
categories: tools howto
published: true
---

I finally came around to switch from `bash` to `zsh`.  While reading [hacker news] [1]
I found a nice little setup on *github*: [oh-my-zsh] [2]


<!-- more -->

Installation
------------

Installation was quite easy:

	$ brew install zsh
	$ cd $HOME
	$ git clone https://github.com/robbyrussell/oh-my-zsh.git .oh-my-zsh
	$ sudo chsh zsh

Configuration
-------------

I did very little configuration.  All I really did is to choose a nice
theme from the many available themes.  Anyhow, my `.zshrc` looks like this:

{% include_code .zshrc shell/zshrc lang:sh %}

Here's how my terminal looks like now.  I'm using the [solarized] [3] colour scheme,
and i'm using the `nanotech` theme:

{% img center http://dl.dropbox.com/u/154097/blog-images/zsh-theme.jpg 'my zsh theme' 'zsh terminal screenshot'%}



  [1]: https://news.ycombinator.com                   "hackernews"
  [2]: https://github.com/robbyrussell/oh-my-zsh      "oh-my-zsh"
  [3]: http://ethanschoonover.com/solarized           "solarized"

