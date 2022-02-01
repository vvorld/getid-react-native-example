//
//  RCTGetID.m
//  RNExample
//
//  Created by Mikhail Akopov on 16.12.2020.
//

#import "RCTGetID.h"
#import "GetIDExample-Swift.h"

@implementation RCTGetID
{
  bool hasListeners;
}

+ (BOOL)requiresMainQueueSetup {
  return YES;
}

- (instancetype)init {
  if (self = [super init]) {
    self.getIDSwiftWrapper = [GetIDSwiftWrapper new];
  }
  return self;
}

- (void)startObserving {
  hasListeners = YES;
}

- (void)stopObserving {
  hasListeners = NO;
}

- (NSArray<NSString *> *)supportedEvents
{
  return @[@"GetIDEvent"];
}

- (void)sendGetIDEventWithBody:(NSDictionary *)body {
  if (hasListeners) {
    [self sendEventWithName:@"GetIDEvent" body:body];
  }
}

RCT_EXPORT_MODULE(GetID);

RCT_EXPORT_METHOD(start:(NSString *)url token:(NSString *)token flowName:(NSString *)flowName) {
  
  dispatch_async(dispatch_get_main_queue(), ^{
    self.getIDSwiftWrapper.delegate = self;
    [self.getIDSwiftWrapper startVerificationFlowWithApiUrl:url token:token flowName:flowName];
  });
}

@end

