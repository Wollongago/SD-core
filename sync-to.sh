GREEN='\033[01;32m'
PURPLE='\033[01;38;5;171m'
RED='\033[0;31m'
NO_COLOR="\033[00m"
DIR=`dirname $(readlink -f "$0")`

rsync -rvht --progress ${DIR}/ fyp:/home/fyp/SD-core --exclude "*/.vscode/" --exclude "*/.git/"  --exclude ".gitignore" --delete