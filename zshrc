# If you come from bash you might have to change your $PATH.
# export PATH=$HOME/bin:/usr/local/bin:$PATH

# Path to your oh-my-zsh installation.
export ZSH=$HOME/.oh-my-zsh

# Set name of the theme to load --- if set to "random", it will
# load a random theme each time oh-my-zsh is loaded, in which case,
# to know which specific one was loaded, run: echo $RANDOM_THEME
# See https://github.com/robbyrussell/oh-my-zsh/wiki/Themes
ZSH_THEME="robbyrussell"

# Set list of themes to pick from when loading at random
# Setting this variable when ZSH_THEME=random will cause zsh to load
# a theme from this variable instead of looking in ~/.oh-my-zsh/themes/
# If set to an empty array, this variable will have no effect.
# ZSH_THEME_RANDOM_CANDIDATES=( "robbyrussell" "agnoster" )

# Uncomment the following line to use case-sensitive completion.
# CASE_SENSITIVE="true"

# Uncomment the following line to use hyphen-insensitive completion.
# Case-sensitive completion must be off. _ and - will be interchangeable.
# HYPHEN_INSENSITIVE="true"

# Uncomment the following line to disable bi-weekly auto-update checks.
# DISABLE_AUTO_UPDATE="true"

# Uncomment the following line to automatically update without prompting.
# DISABLE_UPDATE_PROMPT="true"

# Uncomment the following line to change how often to auto-update (in days).
# export UPDATE_ZSH_DAYS=13

# Uncomment the following line if pasting URLs and other text is messed up.
# DISABLE_MAGIC_FUNCTIONS=true

# Uncomment the following line to disable colors in ls.
# DISABLE_LS_COLORS="true"

# Uncomment the following line to disable auto-setting terminal title.
# DISABLE_AUTO_TITLE="true"

# Uncomment the following line to enable command auto-correction.
# ENABLE_CORRECTION="true"

# Uncomment the following line to display red dots whilst waiting for completion.
# COMPLETION_WAITING_DOTS="true"

# Uncomment the following line if you want to disable marking untracked files
# under VCS as dirty. This makes repository status check for large repositories
# much, much faster.
# DISABLE_UNTRACKED_FILES_DIRTY="true"

# Uncomment the following line if you want to change the command execution time
# stamp shown in the history command output.
# You can set one of the optional three formats:
# "mm/dd/yyyy"|"dd.mm.yyyy"|"yyyy-mm-dd"
# or set a custom format using the strftime function format specifications,
# see 'man strftime' for details.
# HIST_STAMPS="mm/dd/yyyy"

# Would you like to use another custom folder than $ZSH/custom?
# ZSH_CUSTOM=/path/to/new-custom-folder

# Which plugins would you like to load?
# Standard plugins can be found in ~/.oh-my-zsh/plugins/*
# Custom plugins may be added to ~/.oh-my-zsh/custom/plugins/
# Example format: plugins=(rails git textmate ruby lighthouse)
# Add wisely, as too many plugins slow down shell startup.
plugins=(git zsh-autosuggestions)

source $ZSH/oh-my-zsh.sh

# User configuration

# export MANPATH="/usr/local/man:$MANPATH"

# You may need to manually set your language environment
# export LANG=en_US.UTF-8

# Preferred editor for local and remote sessions
# if [[ -n $SSH_CONNECTION ]]; then
#   export EDITOR='vim'
# else
#   export EDITOR='mvim'
# fi

# Compilation flags
# export ARCHFLAGS="-arch x86_64"

# Set personal aliases, overriding those provided by oh-my-zsh libs,
# plugins, and themes. Aliases can be placed here, though oh-my-zsh
# users are encouraged to define aliases within the ZSH_CUSTOM folder.
# For a full list of active aliases, run `alias`.
#
# Example aliases
# alias zshconfig="mate ~/.zshrc"
# alias ohmyzsh="mate ~/.oh-my-zsh"
alias dubbostart='sh /home/chenghai/project/tool/b2benv/dubbo-registry-simple-2.5.3/bin/start.sh'
alias dubbostop='sh /home/chenghai/project/tool/b2benv/dubbo-registry-simple-2.5.3/bin/stop.sh'
alias b2b_test_log='tailf /home/admin/output/www.test2.yyjzt.com/out.log'
alias c='clear'
alias du1='du --max-depth=1 -h'
alias mavensetting='mousepad /mnt/hgfs/.m2/settings.xml &'
alias mavensetting='mousepad /mnt/hgfs/.m2/settings.xml &'
alias findport='sudo netstat -tunlp|grep '
alias cleanpackage="sudo dpkg -l |grep ^rc|awk '{print }' | xargs aptitude -y purge"
alias sy='alsamixer'
alias refresh='source /home/chenghai/.bashrc'
alias speed='speedtest-cli --server 2406 --simple'
alias untar='tar -zxvf '
alias ls='ls -F --color=auto'
alias ll='ls -lFah -rt'
alias grep='grep --color=auto'
alias egrep='egrep --color=auto'
alias fgrep='fgrep --color=auto'
alias diff='colordiff'
alias mount='mount |column -t'
alias path='echo -e ${PATH//:/\\n}'
alias now='date +"%T"'
alias nowtime=now
alias nowdate='date +"%d-%m-%Y"'
alias ping='ping -c 5'
alias fastping='ping -c 100 -i.2'
alias ports='netstat -tulanp'
alias ipt='sudo /sbin/iptables'
alias iptlist='sudo /sbin/iptables -L -n -v --line-numbers'
alias iptlistin='sudo /sbin/iptables -L INPUT -n -v --line-numbers'
alias iptlistout='sudo /sbin/iptables -L OUTPUT -n -v --line-numbers'
alias iptlistfw='sudo /sbin/iptables -L FORWARD -n -v --line-numbers'
alias header='curl -I'
alias headerc='curl -I --compress'
alias rm='rm -I --preserve-root'
alias mv='mv -i'
alias cp='cp -i'
alias ln='ln -i'
alias chown='chown --preserve-root'
alias chmod='chmod --preserve-root'
alias chgrp='chgrp --preserve-root'
alias root='sudo -i'
alias su='sudo -i'
alias reboot='sudo /sbin/reboot'
alias poweroff='sudo /sbin/poweroff'
alias halt='sudo /sbin/halt'
alias shutdown='sudo /sbin/shutdown'
alias meminfo='free -m -l -t'
alias psmem='ps auxf | sort -nr -k 4'
alias psmem10='ps auxf | sort -nr -k 4 | head -10'
alias pscpu='ps auxf | sort -nr -k 3'
alias pscpu10='ps auxf | sort -nr -k 3 | head -10'
alias cpuinfo='lscpu'
##alias cpuinfo='less /proc/cpuinfo' ##
alias gpumeminfo='grep -i --color memory /var/log/Xorg.0.log'
alias wget='wget -c'
alias c='clear'
alias cleanpackage='sudo dpkg -l |grep ^rc|awk '\''{print }'\'' | xargs aptitude -y purge'
alias cpuinfo='lscpu'
alias diff='colordiff'
alias du1='du --max-depth=1 -h '
alias du2='du --max-depth=2 -h '
alias ebash='mousepad ~/.bashrc & '
alias findport='sudo netstat -tunlp|grep'
alias guanji='sudo shutdown -h now'
alias h='history'
alias hotkey='mousepad ~/.config/xfce4/xfconf/xfce-perchannel-xml/xfce4-keyboard-shortcuts.xml &'
alias install='sudo apt install'
alias mavensetting='mousepad /mnt/hgfs/.m2/settings.xml &'
alias meminfo='free -m -l -t'
alias mkcd='function _mkcd(){ mkdir ;cd -version };_mkcd'
alias network='sudo service network-manager restart'
alias now='date +"%T"'
alias nowdate='date +"%d-%m-%Y"'
alias nowtime='now'
alias path='echo -e ${PATH//:/\\n}'
alias ports='netstat -tulanp'
alias pscpu='ps auxf | sort -nr -k 3'
alias pscpu10='ps auxf | sort -nr -k 3 | head -10'
alias psmem='ps auxf | sort -nr -k 4'
alias psmem10='ps auxf | sort -nr -k 4 | head -10'
alias refreshbash='source ~/.bashrc'
# alias top='htop'
alias tianqi='curl wttr.in'
alias startlist='sudo sysv-rc-conf '
alias search='sudo aptitude search '
alias todolist='mousepad /home/chenghai/文档/jzt/b2b/* & '
alias cesu='wget -qO- bench.sh | bash '
alias enet='sudo mousepad  /etc/network/interfaces /etc/resolv.conf & '
alias lock='xfce4-session-logout --suspend'
alias dc-ubuntu='docker run -it ubuntu bash'
alias hg='history|grep'
alias logtest2='ssh b2btest -t tail -fn 200 /home/admin/output/www.test2.yyjzt.com/out.log'
alias logonline-b2b='ssh b2bonline -t tail -fn 200 /home/admin/sbin/datax_node/logs/node.log'
alias youtubedl="youtube-dl --proxy socks5://127.0.0.1:1080/ "
alias bb='exit'
alias urldecode='python -c "import sys, urllib as ul; \
    print ul.unquote_plus(sys.argv[1])"'

alias rili='firefox https://www.baidu.com/baidu\?wd\=%E6%97%A5%E5%8E%86\&tn\=monline_7_dg\&ie\=utf-8'
