#! /bin/sh

REMOTE_SERVER=norad.local
REMOTE_USER=pi

rsync -aS --delete . ${REMOTE_USER}@${REMOTE_SERVER}:/home/pi/src/rsync --exclude='.git*'
echo synced files to ${REMOTE_SERVER}
