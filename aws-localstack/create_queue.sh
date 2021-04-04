#!/bin/bash
aws sqs create-queue --queue-name aws_messages_queue --region default --endpoint-url http://localhost:4566