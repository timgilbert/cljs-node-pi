# cljs-node-pi

This is a small project in which I'm trying to overcome the slow JDK startup time
on the Raspberry Pi and still develop code in Clojure for the pi, by compiling 
ClojureScript to javascript on my local machine and then sending the code to the 
pi to be executed in `node.js`.

This is a work in progress.

In my own setup, I'm running on OS/X locally and deploying to a PI running headless.

## Setup

* Optional: install mdns (bonjour / zeroconf) on the pi 
  [as described here](http://www.raspberrypi.org/forums/viewtopic.php?f=66&t=18207)
  so you can address it as _hostname_.local instead of by IP address.
* Update the pi's server name (or IP) and username in `rsync.sh`.
* Create the directory rsync will copy files into on the pi (default: 
  `mkdir -p ~pi/src/rsync`)
* Add your local development environment's ssh to `~/.ssh/authorized_keys` on the 
  pi as usual, so that you can ssh from the local environment to the pi with no password.
* Set up node 10.x on the pi 
  [as described here](http://nodered.org/docs/hardware/raspberrypi.html).
* On the pi: `sudo npm install -g nodemon`.

## Development

* Locally: run `lein cljsbuild auto`.
** This should start the build process. Whenever you save a ClojureScript file, it will
   be recompiled and copied to the pi via rsync over ssh.
* On the pi: go into the remote directory you created and verify that the files are there
* On the pi: `nodemon run.js`
* Make some changes and save a file. `rsync.sh` should copy them to the pi, the `nodemon`
  should recognised that files have changed and restart the node process.
 