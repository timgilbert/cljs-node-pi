#! /bin/bash

REMOTE_SERVER=norad.local
REMOTE_USER=pi

rsync -aS --delete . "${REMOTE_USER}@${REMOTE_SERVER}:~${REMOTE_USER}/src/rsync" \
   --exclude='.git*'
echo synced files to ${REMOTE_SERVER}
