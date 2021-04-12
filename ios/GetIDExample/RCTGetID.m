//
//  RCTGetID.m
//  RNExample
//
//  Created by Mikhail Akopov on 16.12.2020.
//

#import "RCTGetID.h"
#import "GetIDExample-Swift.h"

@implementation RCTGetID

RCT_EXPORT_MODULE(GetID);

RCT_EXPORT_METHOD(start:(NSString *)url token:(NSString *)token flowName:(NSString *)flowName metadataLabels:(NSDictionary *)metadataLabels) {
  
  dispatch_async(dispatch_get_main_queue(), ^{
    [[GetIDSwiftWrapper new] startVerificationFlowWithApiUrl:url token:token flowName:flowName metadataLabels:metadataLabels];
  });
}

@end

