docker run -d --name doctors-note-backend \
-p 80:8080 \
-p 443:8443 \
-v /Users/alienmojo/workspace/doctors_note/build/libs:/var/lib/jetty/webapps \
jetty:9
