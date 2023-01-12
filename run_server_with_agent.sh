if [ ! -e dd-java-agent.jar ]; then
  echo "dd-java-agent.jar is missing." >&2
  echo "Build it or download it with: wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer" >&2
  exit 1
fi

# Uncomment for more logs about DD tracer
#export DD_TRACE_DEBUG=true

./gradlew bootrun -PwithAgent -Dfile.encoding=UTF-8
