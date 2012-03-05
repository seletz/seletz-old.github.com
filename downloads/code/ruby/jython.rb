require 'formula'

class Jython < Formula
  homepage 'http://www.jython.org'
  url "http://downloads.sourceforge.net/project/jython/jython-dev/2.5.3b1/jython_installer-2.5.3b1.jar",
    :using => :nounzip
  sha1 'bcfc024a93289b2f99bf000fb7666a48fe3d32da'

  def install
    system "java", "-jar", "jython_installer-2.5.3b1.jar", "-s", "-d", libexec
    bin.install_symlink libexec+'bin/jython'
  end
end
