REPOSITORY=/home/ubuntu/gream

cd $REPOSITORY

JAR_NAME=$(ls $REPOSITORY/ | grep 'SNAPSHOT.jar' | tail -n 1)
echo "$JAR_NAME"
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME
echo "$JAR_PATH"

APP_NAME=gream
CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> Nothing to end."
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> $JAR_PATH deploy"
nohup java -jar $JAR_PATH > /dev/null 2> /dev/null < /dev/null &