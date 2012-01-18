export NX_HOME=/opt/nexiles

apt-get install -q -y screen htop curl wget vim

mkdir -p $NX_HOME/{bin,downloads}
cat > /etc/profile.d/nexiles.sh << EOT
export NX_HOME=$NX_HOME
test -f "\$NX_HOME/env.sh" && source \$NX_HOME/env.sh
EOT

# python environment
apt-get install -q -y python2.6
cd $NX_HOME
export PYTHON=/usr/bin/python2.6
export PIP=/usr/local/bin/pip
curl -s http://peak.telecommunity.com/dist/ez_setup.py > $NX_HOME/downloads/ez_setup.py
$PYTHON downloads/ez_setup.py -U

easy_install-2.6 pip
$PIP install virtualenv

virtualenv -p /usr/bin/python2.6 --clear $NX_HOME

. $NX_HOME/bin/activate
pip install requests
pip install kombu==1.5.1

# fix permissions
chown -R vagrant $NX_HOME
